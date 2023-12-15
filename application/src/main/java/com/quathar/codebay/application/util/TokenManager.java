package com.quathar.codebay.application.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.domain.model.User;

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
    private static final String SECRET_KEY       = "jwt.secret-key";
    private static final String REFRESH_TIME_KEY = "jwt.refresh-token-expiration-time";
    private static final String ACCESS_TIME_KEY  = "jwt.access-token-expiration-time";
    private static final String ISSUER           = "Codebay App";
    private static final String TOKEN_TYPE       = "Bearer";
    private static final String REFRESH_TYPE     = "REFRESH";
    private static final String ACCESS_TYPE      = "ACCESS";

    // <<-METHODS->>
    private static Properties getProperties() {
        final Path file = Path.of(System.getProperty("user.dir"), "application",
                "src", "main", "resources",
                "token.properties");
        try (InputStream inStream = new FileInputStream(file.toString())) {
            Properties properties = new Properties();
            properties.load(inStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException("'Token file' NOT FOUND", e);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Input/Output ERROR while reading 'Token file'", e);
        }
    }

    private static String generateToken(Algorithm algorithm, String subject, Instant expirationTime, String type, Map<String, String> claims) {
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
                .withClaim("type", type)
                .withPayload( claims )
                .sign( algorithm );
    }

    private static String generateToken(Algorithm algorithm, String subject, Instant expirationTime, String type) {
        return TokenManager.generateToken(algorithm, subject, expirationTime, type, null);
    }

    /**
     * Generates a pair of tokens (refresh and access) for a given user.
     *
     * @param user The user for whom the tokens are generated.
     * @return TokenPair containing the refresh and access tokens.
     */
    public static TokenPair generateTokenPair(User user) {
        Properties tokenProperties = TokenManager.getProperties();

        String secretKey = tokenProperties.getProperty(SECRET_KEY);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());

        Instant now = Instant.now();
        Instant refreshTokenExpirationTime = now.plusSeconds(
                Long.parseLong(
                        tokenProperties.getProperty(REFRESH_TIME_KEY)
                )
        );
        Instant accessTokenExpirationTime  = now.plusSeconds(
                Long.parseLong(
                        tokenProperties.getProperty(ACCESS_TIME_KEY)
                )
        );

        String subject = user.getId().toString();
        String refreshToken = TokenManager.generateToken(algorithm, subject, refreshTokenExpirationTime, REFRESH_TYPE);
        String accessToken  = TokenManager.generateToken(algorithm, subject, accessTokenExpirationTime, ACCESS_TYPE);

        return TokenPair.builder()
                .type( TOKEN_TYPE )
                .refreshToken( refreshToken )
                .accessToken( accessToken )
                .build();
    }

    /**
     * Verifies the validity of a provided token.
     *
     * @param token The token to be verified.
     * @return Boolean indicating whether the token is valid or not.
     */
    public static Boolean verify(String token) {
        Properties tokenProperties = TokenManager.getProperties();

        String secretKey = tokenProperties.getProperty(SECRET_KEY);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());

//        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);

        return true;
    }

}
