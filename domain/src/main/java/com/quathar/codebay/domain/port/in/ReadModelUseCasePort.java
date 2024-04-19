package com.quathar.codebay.domain.port.in;

/**
 * <h1>Read Model Use Case</h1>
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface ReadModelUseCasePort<M, ID>  {

    /**
     * Retrieves a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to retrieve.
     * @return The retrieved domain model.
     */
    M getById(ID id);

}
