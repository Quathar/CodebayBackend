package com.quathar.codebay.domain.port.in;

/**
 * <h1>Update Model Use Case</h1>
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface UpdateModelUseCasePort<M>  {

    /**
     * Updates an existing domain model.
     *
     * @param model The model to be updated.
     * @return The updated domain model.
     */
    M update(M model);

}
