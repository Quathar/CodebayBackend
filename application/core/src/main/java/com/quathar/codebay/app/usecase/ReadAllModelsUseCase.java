package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.in.ReadAllModelsUseCasePort;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read All Models Use Case Implementation</h1>
 *
 * @param <M> The domain model
 *
 * @see ReadAllModelsUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadAllModelsUseCase<M> implements ReadAllModelsUseCasePort<M> {

    // <<-FIELD->>
    /**
     * The CRUD repository port.
     */
    @NonNull
    private final CrudRepositoryPort<M, ?> crudRepositoryPort;

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<M> getAll(int pageIndex, int pageSize) {
        return this.crudRepositoryPort.findAll(pageIndex, pageSize);
    }

}
