package com.quathar.codebay.domain.port.in.security;

import com.quathar.codebay.domain.valueobject.security.TokenPair;

/**
 * <h1>Refresh Token Use Case</h1>
 *
 * Use case for refreshing tokens.
 *
 * @since 2024-07-28
 * @version 1.0
 * @author Q
 */
public interface RefreshTokenUseCasePort {

    /**
     * Refreshes the tokens based on the provided refresh token.
     *
     * @param token The refresh token used to obtain a new access token and a new refresh token
     * @return A {@link TokenPair} containing the access and refresh tokens after a successful refresh
     */
    TokenPair refresh(String token);

}
