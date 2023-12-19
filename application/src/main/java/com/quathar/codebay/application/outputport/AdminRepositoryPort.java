package com.quathar.codebay.application.outputport;

import com.quathar.codebay.domain.model.Administrator;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>Administrator Repository Port</h1>
 * <br>
 * <p>
 *     Represents a contract for managing administrator domain models.
 * </p>
 *
 * @since 2023-12-19
 * @version 2.0
 * @author Q
 */
public interface AdminRepositoryPort extends CrudRepositoryPort<Administrator, UUID> {

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
