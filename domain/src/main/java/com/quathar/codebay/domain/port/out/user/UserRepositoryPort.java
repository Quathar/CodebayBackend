package com.quathar.codebay.domain.port.out.user;

import com.quathar.codebay.domain.model.User;

/**
 * <h1>User Repository Port</h1>
 *
 * Represents a contract for managing User domain models.
 *
 * @see GenericUserRepositoryPort
 * @see User
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface UserRepositoryPort
       extends   GenericUserRepositoryPort<User, java.util.UUID> {

    /**
     * Retrieves a user by their unique authentication key.
     *
     * @param authenticationKey authentication key of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    java.util.Optional<User> findByAuthenticationKey(String authenticationKey);

    /**
     * Increments the count of successful authentications for the user with the given username.
     *
     * @param username the username of the user whose successful authentication count will be incremented
     */
    void incrementSuccessfulAuth(String username);

    /**
     * Increments the count of failed authentications for the user with the given username.
     *
     * @param username the username of the user whose failed authentication count will be incremented
     */
    void incrementFailedAuth(String username);

}
