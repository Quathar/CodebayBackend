package com.quathar.codebay.infra.security.adapter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.IncorrectClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.MissingClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.quathar.codebay.domain.exception.security.NotAccessTokenException;
import com.quathar.codebay.domain.exception.security.NotRefreshTokenException;
import com.quathar.codebay.domain.exception.security.TokenVerificationException;
import com.quathar.codebay.domain.port.out.security.TokenServicePort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

/**
 * <h1>JWT (JSON Web Token) Token Service Adapter</h1>
 *
 * @see TokenServicePort
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Slf4j
@Component
public class JwtServiceAdapter implements TokenServicePort {

    // <<-CONSTANTS->>
    /**
     * The issuer of the JWT.
     */
    private static final String ISSUER = "Codebay";
    /**
     * The intended audience specifying the 'application'.
     */
    private static final String APP_AUDIENCE = "Application";
    /**
     * The intended audience specifying the 'authorization server'.
     */
    private static final String AUTH_AUDIENCE = "Authorization Server";
    /**
     * The claim key used to represent the user's role.
     */
    private static final String ROLE_CLAIM = "role";

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

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code JwtServiceAdapter} with the provided secret key and token expiration times.
     *
     * @param secretKey                  The secret key used for JWT signing.
     * @param accessTokenExpirationTime  The expiration time for access tokens, in seconds.
     * @param refreshTokenExpirationTime The expiration time for refresh tokens, in seconds.
     */
    public JwtServiceAdapter(
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

    // <<-METHODS->>
    @Override
    public TokenPair generateTokenPair(String subject, Map<String, ?> extraClaims) {
        log.info("Generating a new token pair");
        Instant now = Instant.now();
        Instant accessTokenExpirationTime = now.plusSeconds(this.accessTokenExpirationTime);
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
                .withAudience( APP_AUDIENCE )
                .sign(this.algorithm);
        String refreshToken = JWT.create()
                .withPayload( extraClaims )
                .withIssuer( ISSUER )
                .withSubject( subject )
                .withIssuedAt( now )
                .withExpiresAt( refreshTokenExpirationTime )
                .withNotBefore( accessTokenExpirationTime )
                // TODO: This is working but check this, try to use only AUTH_AUDIENCE
                .withAudience( APP_AUDIENCE, AUTH_AUDIENCE )
                .sign( this.algorithm );

        log.debug("Returning access token: {}", accessToken);
        log.debug("Returning refresh token: {}", refreshToken);
        return TokenPair.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public TokenPair generateTokenPair(String subject) {
        return this.generateTokenPair(subject, null);
    }

    /**
     * Verifies the authenticity of the provided token.
     *
     * @param token The token to verify.
     * @return The decoded JWT if verification is successful.
     * @throws AlgorithmMismatchException     if the algorithm stated in the token's header is not equal to
     *                                        the one defined in the {@link com.auth0.jwt.JWTVerifier}.
     * @throws SignatureVerificationException if the signature is invalid.
     * @throws TokenExpiredException          if the token has expired.
     * @throws MissingClaimException          if a claim to be verified is missing.
     * @throws IncorrectClaimException        if a claim contained a different value than the expected one.
     * @throws JWTDecodeException             if the token is null or doesn't have the correct structure
     */
    private DecodedJWT verify(String token) {
        log.debug("Verifying token {}", token);
        try {
            return JWT.require(this.algorithm)
                    .build()
                    .verify(token);
        } catch (
                AlgorithmMismatchException
                | SignatureVerificationException
                | TokenExpiredException
                | MissingClaimException
                | IncorrectClaimException
                | JWTDecodeException e
        ) {
            throw new TokenVerificationException(e);
        }
    }

    @Override
    public String extractUsername(String token) {
        log.debug("Extracting << username >> from token: {}", token);
        DecodedJWT decoded = this.verify(token);

        if (!decoded.getAudience().contains(APP_AUDIENCE)) {
            log.error("The token used for access is not an 'access token'.");
            // NOT IMPLEMENTED - Token registry
            // this.invalidTokenFamily(decoded.getClaim(FAMILY_CLAIM))
            throw new NotAccessTokenException();
        }
        return decoded.getSubject();
    }

    @Override
    public TokenPair refresh(String token) {
        log.debug("Refreshing token: {}", token);
        DecodedJWT decoded = this.verify(token);

        // The two tokens we create have an audience,
        // so we don't do null check
        if (!decoded.getAudience().contains(AUTH_AUDIENCE)) {
            log.error("The token used for refreshing is not a 'refresh token'.");
            // NOT IMPLEMENTED - Token registry
            // this.invalidTokenFamily(decoded.getClaim(FAMILY_CLAIM))
            throw new NotRefreshTokenException();
        }

        var username = decoded.getSubject();
        var role     = decoded.getClaim(ROLE_CLAIM).asString();
        log.debug("The new token pair will be generated with username [ {} ] and role [ {} ]", username, role);
        return this.generateTokenPair( username, Map.of(ROLE_CLAIM, role) );
    }

}
