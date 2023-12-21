package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.domain.exception.ResourceNotFoundException;

/**
 * <h1>Read Model Use Case</h1>
 * <br>
 * <p>
 *     This interface defines methods to retrieve domain models and collections of domain models.
 * </p>
 *
 * @param <M> The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface ReadModelUseCase<M, ID>  {

    /**
     * Retrieves a collection of domain models with pagination support.
     *
     * @param pageNumber The page number.
     * @param pageSize   The number of items per page.
     * @return A set of domain models within the specified page and size.
     */
    java.util.List<M> getAll(int pageNumber, int pageSize);

    /**
     * Retrieves a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to retrieve.
     * @return The retrieved domain model, or null if not found.
     * @throws ResourceNotFoundException if the given identifier does not point an existing resource of the model
     */
    M getById(ID id) throws ResourceNotFoundException;

}
