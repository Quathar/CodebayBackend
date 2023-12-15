package com.quathar.codebay.application.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.TokenPair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.Instant;
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

    private static String generateToken(Algorithm algorithm, String subject, Instant expirationTime, String type, Map<String, ?> claims) {
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
                .withClaim( "type", type )
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
    public static TokenPair generateTokenPair(String subject, Map<String, ?> claims) {
        if (subject == null)
            throw new RuntimeException("No Subject provided to generate the pairs");

        Properties tokenProperties = TokenManager.getProperties();

        String secretKey = tokenProperties.getProperty(SECRET_KEY);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());

        Instant now = Instant.now();
        Instant refreshTokenExpirationTime = TokenManager.getExpirationTime(now, tokenProperties, REFRESH_TIME_KEY);
        Instant accessTokenExpirationTime  = TokenManager.getExpirationTime(now, tokenProperties, ACCESS_TIME_KEY);

        String refreshToken = TokenManager.generateToken(
                algorithm,
                subject,
                refreshTokenExpirationTime,
                REFRESH_TYPE,
                claims
        );
        String accessToken  = TokenManager.generateToken(
                algorithm,
                subject,
                accessTokenExpirationTime,
                ACCESS_TYPE,
                claims
        );

        return TokenPair.builder()
                .type( TOKEN_TYPE )
                .refreshToken( refreshToken )
                .accessToken( accessToken )
                .build();
    }

    /**
     * Generates a pair of tokens (refresh and access) for a given user.
     *
     * @param subject The subject for whom the tokens are generated.
     * @return TokenPair containing the refresh and access tokens.
     */
    public static TokenPair generateTokenPair(String subject) {
        return TokenManager.generateTokenPair(subject, Map.of());
    }

    /**
     * Verifies the validity of a provided token.
     *
     * @param token The token to be verified.
     * @return Boolean indicating whether the token is valid or not.
     * @throws com.auth0.jwt.exceptions.JWTVerificationException If the token cannot be verified
     */
    public static Boolean verify(String token) {
        Properties tokenProperties = TokenManager.getProperties();
        String secretKey = tokenProperties.getProperty(SECRET_KEY);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
        try {
            JWT.require(algorithm).build().verify(token);
            return true;
        } catch (com.auth0.jwt.exceptions.JWTVerificationException e) {
            System.err.println("saslta la exepcion");
            return false;
        }
    }

}
