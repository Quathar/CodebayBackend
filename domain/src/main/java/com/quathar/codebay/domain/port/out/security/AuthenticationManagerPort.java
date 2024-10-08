package com.quathar.codebay.domain.port.out.security;

import com.quathar.codebay.domain.valueobject.security.TokenPair;

/**
 * <h1>Authentication Manager Port</h1>
 *
 * Port for performing user authentication.
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface AuthenticationManagerPort {

    /**
     * Performs user authentication based on the provided authentication key and password.
     *
     * @param authenticationKey The authentication key (e.g., username or email) of the user
     * @param password          The password of the user
     * @return A {@link TokenPair} containing the access and refresh tokens upon successful authentication
     */
    TokenPair performAuthentication(String authenticationKey, String password);

    /**
     * Refreshes the authentication tokens based on the provided refresh token.
     *
     * @param token The refresh token
     * @return A {@link TokenPair} containing the access and refresh tokens upon successful authentication
     */
    TokenPair performRefresh(String token);

}
