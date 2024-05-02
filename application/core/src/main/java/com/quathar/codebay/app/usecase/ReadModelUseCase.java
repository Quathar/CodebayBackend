package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.port.in.ReadModelUseCasePort;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read Model Use Case Implementation</h1>
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type.
 *
 * @see ReadModelUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadModelUseCase<M, ID> implements ReadModelUseCasePort<M, ID> {

    // <<-FIELD->>
    /**
     * The CRUD repository port.
     */
    @NonNull
    private final CrudRepositoryPort<M, ID> crudRepositoryPort;

    // <<-METHOD->>
    @Override
    public M getById(ID id) {
        return this.crudRepositoryPort
                .findById(id)
                .orElseThrow(ModelNotFoundException::new);
    }

}
