package com.quathar.codebay.infra.rest.security.usecase;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.quathar.codebay.domain.usecase.security.token.ExtractUsernameUseCase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <h1>Extract Username Use Case Implementation</h1>
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Component
public final class ExtractUsername implements ExtractUsernameUseCase {

    // <<-FIELDS->>
    private final String secretKey;
    private final Algorithm algorithm;

    // <<-CONSTRUCTOR->>
    public ExtractUsername(@Value("${jwt.secret-key}") String secretKey) {
        this.secretKey = secretKey;
        this.algorithm = Algorithm.HMAC256( this.generateKey() );
    }

    // <<-METHODS->>
    /**
     * Generates the key byte array from the secret key string.
     *
     * @return The byte array representing the generated key.
     */
    private byte[] generateKey() {
        return java.util.Base64.getDecoder().decode(this.secretKey);
    }

    /**
     * Verifies the authenticity of the provided token.
     *
     * @param token The token to verify.
     * @return The decoded JWT if verification is successful.
     */
    private DecodedJWT verify(String token) {
        return JWT.require( this.algorithm )
                .build()
                .verify( token );
    }

    @Override
    public String extractUsername(String token) {
        return this.verify(token).getSubject();
    }

}
