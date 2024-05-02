package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.in.UpdateModelUseCasePort;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Update Model Use Case Implementation</h1>
 *
 * @param <M> The domain model
 *
 * @see UpdateModelUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class UpdateModelUseCase<M> implements UpdateModelUseCasePort<M> {

    // <<-FIELD->>
    /**
     * The CRUD repository port.
     */
    @NonNull
    private final CrudRepositoryPort<M, ?> crudRepositoryPort;

    // <<-METHOD->>
    @Override
    public M update(M model) {
        return this.crudRepositoryPort.update(model);
    }

}
