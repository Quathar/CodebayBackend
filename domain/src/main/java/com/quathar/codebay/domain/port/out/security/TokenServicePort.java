package com.quathar.codebay.domain.port.out.security;

import com.quathar.codebay.domain.valueobject.security.TokenPair;

/**
 * <h1>Token Service Port</h1>
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface TokenServicePort {

    /**
     * Generates a pair of tokens (access token and refresh token) for the specified subject
     * along with additional custom claims.
     *
     * @param subject     The subject for which the tokens are generated.
     * @param extraClaims Additional custom claims to be included in the tokens.
     * @return A {@link TokenPair} of JWT.
     */
    TokenPair generateTokenPair(String subject, java.util.Map<String, ?> extraClaims);

    /**
     * Generates a pair of tokens (access token and refresh token) for the specified subject.
     *
     * @param subject The subject for which the tokens are generated.
     * @return A {@link TokenPair} of JWT.
     */
    TokenPair generateTokenPair(String subject);

    /**
     * Extracts the username from the provided token.
     *
     * @param token The JWT token.
     * @return The username extracted from the token.
     */
    String extractUsername(String token);

}
