package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.in.CreateModelUseCasePort;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Create Model Use Case Implementation</h1>
 *
 * @param <M> The domain model
 *
 * @see CreateModelUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class CreateModelUseCase<M> implements CreateModelUseCasePort<M> {

    // <<-FIELD->>
    /**
     * The CRUD repository port.
     */
    @NonNull
    private final CrudRepositoryPort<M, ?> crudRepositoryPort;

    // <<-METHOD->>
    @Override
    public M create(M model) {
        return this.crudRepositoryPort.save(model);
    }

}
