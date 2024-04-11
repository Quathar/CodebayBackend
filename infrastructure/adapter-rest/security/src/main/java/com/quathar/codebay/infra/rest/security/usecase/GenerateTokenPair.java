package com.quathar.codebay.infra.rest.security.usecase;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.domain.usecase.security.token.GenerateTokenPairUseCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

/**
 * <h1>Generate Token Pair Use Case Implementation</h1>
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Component
public final class GenerateTokenPair implements GenerateTokenPairUseCase {

    private static final Logger log = LoggerFactory.getLogger(JwtServiceAdapter.class);

    // <<-CONSTANT->>
    /**
     * The issuer of the JWT.
     */
    private static final String ISSUER = "Codebay";

    // <<-FIELDS->>
    /**
     * The secret key used to sign JWTs.
     */
    private final String secretKey;
    /**
     * The algorithm used for JWT signing.
     */
    private final Algorithm algorithm;
    /**
     * The expiration time for access tokens, in seconds.
     */
    private final Long accessTokenExpirationTime;
    /**
     * The expiration time for refresh tokens, in seconds.
     */
    private final Long refreshTokenExpirationTime;


    /**
     * Constructs a {@code JwtServiceAdapter} with the provided secret key and token expiration times.
     *
     * @param secretKey                  The secret key used for JWT signing.
     * @param accessTokenExpirationTime  The expiration time for access tokens, in seconds.
     * @param refreshTokenExpirationTime The expiration time for refresh tokens, in seconds.
     */
    @Autowired
    public GenerateTokenPair(
            @Value("${jwt.secret-key}")
            String secretKey,
            @Value("${jwt.access-token.expiration-time}")
            Long accessTokenExpirationTime,
            @Value("${jwt.refresh-token.expiration-time}")
            Long refreshTokenExpirationTime
    ) {
        this.secretKey                  = secretKey;
        this.algorithm                  = Algorithm.HMAC256( this.generateKey() );
        this.accessTokenExpirationTime  = accessTokenExpirationTime;
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }

    /**
     * Generates the key byte array from the secret key string.
     *
     * @return The byte array representing the generated key.
     */
    private byte[] generateKey() {
        return java.util.Base64.getDecoder().decode(this.secretKey);
    }

    @Override
    public TokenPair generateTokenPair(String subject, Map<String, ?> extraClaims) {
        Instant now = Instant.now();
        Instant accessTokenExpirationTime  = now.plusSeconds(this.accessTokenExpirationTime);
        Instant refreshTokenExpirationTime = now.plusSeconds(this.refreshTokenExpirationTime);

        // Look for more available claims in this library
        // these are some we haven't implemented here, but could be useful:
        // ---
        // This claim is to identify this specific token if u want to implement a registry
        //      .withJWTId( "" )
        // This can be useful if you use more than 1 algorithm to sign the JWT
        // This is added to the header (not a claim)
        //      .withKeyId( "" )
        // A claim with no value, only the key
        //      .withNullClaim("Only for you to know this exist ;)")
        String accessToken = JWT.create()
                .withPayload( extraClaims )
                .withIssuer( ISSUER )
                .withSubject( subject )
                .withIssuedAt( now )
                .withExpiresAt( accessTokenExpirationTime )
                .sign( this.algorithm );
        String refreshToken = JWT.create()
                .withPayload( extraClaims )
                .withIssuer( ISSUER )
                .withSubject( subject )
                .withIssuedAt( now )
                .withExpiresAt( refreshTokenExpirationTime )
                .withNotBefore( accessTokenExpirationTime )
                .sign( this.algorithm );

        return TokenPair.builder()
                .accessToken( accessToken )
                .refreshToken( refreshToken )
                .build();
    }

    @Override
    public TokenPair generateTokenPair(String subject) {
        return this.generateTokenPair(subject, null);
    }

}
