package com.quathar.codebay.domain.port.out.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import java.util.Optional;

/**
 * <h1>Abstract User Repository Port</h1>
 *
 * Represents a contract for managing abstract User domain models.
 *
 * @see CrudRepositoryPort
 * @see User
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface AbstractUserRepositoryPort<M extends User, ID>
       extends   CrudRepositoryPort<M, ID> {

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return An {@link Optional} containing the user if found, empty otherwise
     */
    Optional<M> findByUsername(String username);

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user to retrieve
     * @return An {@link Optional} containing the user if found, empty otherwise
     */
    Optional<M> findByEmail(String email);

    /**
     * Retrieves the ID of a user by their username.
     *
     * @param username the username of the user whose ID is to be retrieved
     * @return An {@link Optional} containing the ID of the user if found, empty otherwise
     */
    Optional<ID> findIdByUsername(String username);

    /**
     * Deletes a user by their username.
     *
     * @param username the username of the user to delete
     */
    void deleteByUsername(String username);

}
