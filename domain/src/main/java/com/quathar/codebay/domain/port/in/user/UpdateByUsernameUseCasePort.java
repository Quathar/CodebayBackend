package com.quathar.codebay.domain.port.in.user;

import com.quathar.codebay.domain.model.User;

/**
 * <h1>Update User by Username Use Case</h1>
 *
 * @param <M> The type of the user model
 *
 * @since 2024-05-05
 * @version 1.0
 * @author Q
 */
public interface UpdateByUsernameUseCasePort<M extends User> {

    /**
     * Retrieves a user by the username.
     *
     * @param userToUpdate The user to be updated.
     * @return The user model corresponding to the username
     */
    M updateByUsername(M userToUpdate);

}
