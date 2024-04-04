package com.quathar.codebay.domain.usecase.user;

import com.quathar.codebay.domain.model.User;

/**
 * <h1>Retrieve by username Use Case</h1>
 *
 * @param <M> The type of the user model
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public interface RetrieveByUsernameUseCase<M extends User> {

    /**
     * Retrieves a user by the username.
     *
     * @param username the username of the user to retrieve
     * @return the user model corresponding to the username
     */
    M getByUsername(String username);

}
