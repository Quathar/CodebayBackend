package com.quathar.codebay.application.outputport;

/**
 * <h1>CRUD Repository Port</h1>
 * <br>
 * <p>
 *     Represents a contract for basic CRUD operations on a domain model.
 * </p>
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface CrudRepositoryPort<M, ID> {

    /**
     * Retrieves a collection of domain models with pagination support.
     *
     * @param pageIndex  The page index.
     * @param pageSize   The number of items per page.
     * @return A set of domain models within the specified page and size.
     */
    java.util.List<M> findAll(int pageIndex, int pageSize);

    /**
     * Finds a domain model by its identifier.
     *
     * @param id The identifier of the domain model
     * @return An {@link java.util.Optional} containing the domain model if found, otherwise empty
     */
    java.util.Optional<M> findById(ID id);

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
     */
    void deleteById(ID id);

}
