package com.quathar.codebay.domain.port.in.security;

import com.quathar.codebay.domain.valueobject.security.TokenPair;

/**
 * <h1>Authentication Use Case</h1>
 *
 * Use case for authentication.
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface AuthenticationUseCasePort {

    /**
     * Performs user authentication based on the provided authentication key and password.
     *
     * @param authenticationKey The authentication key (e.g., username or email) of the user
     * @param password          The password of the user
     * @return A {@link TokenPair} containing the access and refresh tokens upon successful authentication
     */
    TokenPair authenticate(String authenticationKey, String password);

}
