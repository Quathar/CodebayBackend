package com.quathar.codebay.application.usecase;

import com.quathar.codebay.domain.model.TokenPair;

/**
 * <h1>Administrator Log In Use Case</h1>
 * <br>
 * <p>
 *     Represents the Use Case for admin login/authentication.
 * </p>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface LoginAdminUseCase {

    /**
     * Authenticates a user admin on the provided username and password.
     *
     * @param username The username of the admin attempting to log in.
     * @param password The password of the admin attempting to log in.
     * @return A token/session identifier if authentication is successful; otherwise, null.
     */
    TokenPair authAdminByUsername(String username, String password);

    /**
     * Authenticates a admin based on the provided username and password.
     *
     * @param username The username of the admin attempting to log in.
     * @param password The password of the admin attempting to log in.
     * @return A token/session identifier if authentication is successful; otherwise, null.
     */
    TokenPair authAdminByEmail(String username, String password);

}
