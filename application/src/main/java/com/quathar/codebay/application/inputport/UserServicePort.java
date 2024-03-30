package com.quathar.codebay.application.inputport;

import com.quathar.codebay.domain.model.User;

/**
 * <h1>User Service Port</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface UserServicePort extends CrudServicePort<User, java.util.UUID> {

    /**
     * Retrieves a user by the username.
     *
     * @param username the username of the user to retrieve
     * @return the user model corresponding to the username
     */
    User getByUsername(String username);

    /**
     * Deletes a user by the username.
     *
     * @param username the username of the user to delete
     */
    void deleteByUsername(String username);

}
