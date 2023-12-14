package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.domain.exception.ResourceNotFoundException;

/**
 * <h1>Read Model Use Case</h1>
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
     * Retrieves a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to retrieve.
     * @return The retrieved domain model, or null if not found.
     * @throws ResourceNotFoundException if the given identifier does not point an existing resource of the model
     */
    M getById(ID id) throws ResourceNotFoundException;

}
