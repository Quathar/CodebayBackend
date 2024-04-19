package com.quathar.codebay.domain.port.out.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import java.util.Optional;

/**
 * <h1>Generic User Repository Port</h1>
 *
 * Represents a contract for managing generic User domain models.
 *
 * @see CrudRepositoryPort
 * @see User
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface GenericUserRepositoryPort<M extends User, ID>
       extends   CrudRepositoryPort<M, ID> {

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<M> findByUsername(String username);

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user to retrieve
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<M> findByEmail(String email);

    /**
     * Deletes a user by their username.
     *
     * @param username the username of the user to delete
     */
    void deleteByUsername(String username);

}
