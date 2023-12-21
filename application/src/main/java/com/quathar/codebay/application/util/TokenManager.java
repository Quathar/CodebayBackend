package com.quathar.codebay.application.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.TokenPair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <h1>Token Manager</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public abstract class TokenManager {

    // <<-CONSTANTS->>
    /**
     *
     */
    public enum Role { BASIC, ADMIN }
    /**
     * Represents the file path to the token properties file.<br>
     * <br>
     * The field is made public and non-final to enable test scenarios
     * where the class needs to load the properties file
     * from it's own module.
     */
    public static Path FILE = Path.of(System.getProperty("user.dir"), "application",
            "src", "main", "resources",
            "token.properties");
    private static final String SECRET_KEY       = "jwt.secret-key";
    private static final String REFRESH_TIME_KEY = "jwt.refresh-token-expiration-time";
    private static final String ACCESS_TIME_KEY  = "jwt.access-token-expiration-time";
    private static final String ISSUER           = "Codebay App";
    private static final String TOKEN_TYPE       = "Bearer";
    private static final String REFRESH_TYPE     = "REFRESH";
    private static final String ACCESS_TYPE      = "ACCESS";
    private static final String CLAIM_ROLE       = "role";
    private static final String CLAIM_TYPE       = "type";

    // <<-METHODS->>
    private static Properties getProperties() {
        try (InputStream inStream = new FileInputStream(FILE.toString())) {
            Properties properties = new Properties();
            properties.load(inStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException("'Token file' NOT FOUND", e);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Input/Output ERROR while reading 'Token file'", e);
        }
    }

    private static String generateToken(Algorithm algorithm, String subject, Instant expirationTime, Map<String, ?> claims) {
        return JWT.create()
                .withIssuer( ISSUER )
                .withIssuedAt( Instant.now() )
                .withSubject( subject )
                .withExpiresAt( expirationTime )
                // This claim is to identify this specific token
//                .withJWTId( "" )
                // This can be useful if you use more than 1 algorithm to sign the JWT
                // This is added to the header (not a claim)
//                .withKeyId( "" )
                // This is for the token not being operative until this time is reached
                // In this example I put a day
//                .withNotBefore( Instant.now().plusSeconds(86400) )
                // A claim with no value, only the key
//                .withNullClaim("Only for you to know this exist ;)")
                .withPayload( claims )
                .sign( algorithm );
    }

    private static Instant getExpirationTime(Instant instant, Properties properties, String key) {
        return instant.plusSeconds(
                Long.parseLong(
                        properties.getProperty(key)
                )
        );
    }

    /**
     * Generates a pair of tokens (refresh and access) for a given user.
     *
     * @param subject The subject for whom the tokens are generated.
     * @param claims  The claims to include in the token.
     * @return TokenPair containing the refresh and access tokens.
     *
     */
    public static TokenPair generateTokenPair(String subject, Map<String, Object> claims) {
        if (subject == null)
            throw new RuntimeException("No Subject provided to generate the pairs");

        Properties tokenProperties = TokenManager.getProperties();

        String secretKey = tokenProperties.getProperty(SECRET_KEY);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());

        Instant now = Instant.now();
        Instant refreshTokenExpirationTime = TokenManager.getExpirationTime(now, tokenProperties, REFRESH_TIME_KEY);
        Instant accessTokenExpirationTime  = TokenManager.getExpirationTime(now, tokenProperties, ACCESS_TIME_KEY);

        Map<String, Object> refreshTokenClaims = new HashMap<>(claims);
        Map<String, Object> accessTokenClaims  = new HashMap<>(claims);
        refreshTokenClaims.put(CLAIM_TYPE, REFRESH_TYPE);
        accessTokenClaims .put(CLAIM_TYPE, ACCESS_TYPE);

        String refreshToken = TokenManager.generateToken(
                algorithm,
                subject,
                refreshTokenExpirationTime,
                refreshTokenClaims
        );
        String accessToken  = TokenManager.generateToken(
                algorithm,
                subject,
                accessTokenExpirationTime,
                accessTokenClaims
        );

        return TokenPair.builder()
                .type( TOKEN_TYPE )
                .refreshToken( refreshToken )
                .accessToken( accessToken )
                .build();
    }

    /**
     * Generates a TokenPair containing the refresh and access tokens for the specified subject and role.
     *
     * @param subject The subject for whom the tokens are generated.
     * @param role    The role associated with the subject.
     * @return TokenPair containing the refresh and access tokens.
     */
    public static TokenPair generateTokenPair(String subject, Role role) {
        return TokenManager.generateTokenPair(subject, Map.of(CLAIM_ROLE, role.name()));
    }

    /**
     * Generates a TokenPair containing the refresh and access tokens for the specified subject with a basic role.
     *
     * @param subject The subject for whom the tokens are generated.
     * @return TokenPair containing the refresh and access tokens.
     */
    public static TokenPair generateTokenPair(String subject) {
        return TokenManager.generateTokenPair(subject, Role.BASIC);
    }

    /**
     * Verifies the validity of a provided token for a specific role.
     *
     * @param token The token to be verified.
     * @param role The role against which the token's validity is checked.
     * @return boolean indicating whether the token is valid ({@code true}) or not ({@code false}).
     * @throws com.auth0.jwt.exceptions.JWTVerificationException If the token cannot be verified
     */
    public static boolean verify(String token, Role role) {
        Algorithm algorithm = Algorithm.HMAC256(
                TokenManager.getProperties()
                        .getProperty(SECRET_KEY)
                        .getBytes()
        );
        try {
            com.auth0.jwt.interfaces.DecodedJWT decodedJWT = JWT.require(algorithm)
                    .build()
                    .verify(token);


            return decodedJWT.getClaim(CLAIM_TYPE)
                    .asString()
                    .equals(ACCESS_TYPE)
                    // This second check is to ensure the admins to be able
                    // to access normal paths
                && (decodedJWT.getClaim(CLAIM_ROLE)
                    .asString()
                    .equals(Role.ADMIN.name())
                || decodedJWT.getClaim(CLAIM_ROLE)
                    .asString()
                    .equals(role.name()));
        } catch (com.auth0.jwt.exceptions.JWTVerificationException e) {
            return false;
        }
    }

    /**
     * Verifies the validity of a provided token for the BASIC role.
     *
     * @param token The token to be verified.
     * @return boolean indicating whether the token is valid ({@code true}) or not ({@code false}).
     * @throws com.auth0.jwt.exceptions.JWTVerificationException If the token cannot be verified
     */
    public static boolean verify(String token) {
        return TokenManager.verify(token, Role.BASIC);
    }

}
