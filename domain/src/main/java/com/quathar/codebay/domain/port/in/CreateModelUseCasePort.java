package com.quathar.codebay.domain.port.in;

/**
 * <h1>Create Model Use Case</h1>
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface CreateModelUseCasePort<M> {

    /**
     * Creates a new domain model.
     *
     * @param model The model to be created.
     * @return The created domain model.
     */
    M create(M model);

}
