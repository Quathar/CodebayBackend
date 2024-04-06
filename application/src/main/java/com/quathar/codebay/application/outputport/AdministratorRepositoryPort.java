package com.quathar.codebay.application.outputport;

import com.quathar.codebay.domain.model.Administrator;

import java.util.Optional;

/**
 * <h1>Administrator Repository Port</h1>
 *
 * Represents a contract for managing administrator domain models.
 *
 * @since 2023-12-19
 * @version 2.0
 * @author Q
 */
public interface AdministratorRepositoryPort extends CrudRepositoryPort<Administrator, java.util.UUID> {

    /**
     * Retrieves an admin by their username.
     *
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<Administrator> findByUsername(String username);

    /**
     * Retrieves an admin by their email.
     *
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<Administrator> findByEmail(String email);

}
