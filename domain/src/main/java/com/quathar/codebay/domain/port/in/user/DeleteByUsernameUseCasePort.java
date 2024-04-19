package com.quathar.codebay.domain.port.in.user;

/**
 * <h1>Delete User by Username Use Case</h1>
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public interface DeleteByUsernameUseCasePort {

    /**
     * Deletes a user by the username.
     *
     * @param username The username of the user to delete
     */
    void deleteByUsername(String username);

}
