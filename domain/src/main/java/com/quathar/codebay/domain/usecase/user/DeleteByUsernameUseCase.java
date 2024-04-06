package com.quathar.codebay.domain.usecase.user;

/**
 * <h1>Delete by Username Use Case</h1>
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public interface DeleteByUsernameUseCase {

    /**
     * Deletes a user by the username.
     *
     * @param username The username of the user to delete
     */
    void deleteByUsername(String username);

}
