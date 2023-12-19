package com.quathar.codebay.application.usecase;

import com.quathar.codebay.domain.model.TokenPair;

/**
 * <h1>Log In Use Case</h1>
 * <br>
 * <p>
 *     Represents the Use Case for user login/authentication.
 * </p>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface LoginUserUseCase {

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A token/session identifier if authentication is successful; otherwise, null.
     */
    TokenPair authByUsername(String username, String password);

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A token/session identifier if authentication is successful; otherwise, null.
     */
    TokenPair authByEmail(String username, String password);

}
