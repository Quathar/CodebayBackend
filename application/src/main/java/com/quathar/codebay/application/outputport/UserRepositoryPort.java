package com.quathar.codebay.application.outputport;

import com.quathar.codebay.domain.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>User Repository Port</h1>
 * <br>
 * <p>
 *     Represents a contract for managing User domain models.
 * </p>
 *
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface UserRepositoryPort extends CrudRepositoryPort<User, UUID> {

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<User> findByUsername(String username);

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<User> findByEmail(String email);

    /**
     * Retrieves a user by their unique authentication key.
     *
     * @param uniqueAuthKey authentication key of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<User> findByAuthenticationKey(String uniqueAuthKey);

    /**
     * Deletes a user by their username.
     *
     * @param username the username of the user to delete
     */
    void deleteByUsername(String username);

}
