package com.quathar.codebay.application.outputport;

import java.util.Optional;

/**
 * <h1>CRUD Repository Port</h1>
 * <p>
 *     Represents a contract for basic CRUD operations on a domain model.
 * </p>
 *
 * @param <M> The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface CrudRepositoryPort<M, ID> {

    /**
     * Finds a domain model by its identifier.
     *
     * @param id The identifier of the domain model
     * @return An {@link Optional} containing the domain model if found, otherwise empty
     */
    Optional<M> findById(ID id);

    /**
     * Saves a domain model.
     *
     * @param model The domain model to be saved
     * @return The saved domain model
     */
    M save(M model);

    /**
     * Updates a domain model.
     *
     * @param model The domain model to be updated
     * @return The updated domain model
     */
    M update(M model);

    /**
     * Deletes a domain model by its identifier.
     *
     * @param id The identifier of the domain model to delete
     * @return {@code true} if the deletion was successful, {@code false} otherwise
     */
    boolean deleteById(ID id);

}
