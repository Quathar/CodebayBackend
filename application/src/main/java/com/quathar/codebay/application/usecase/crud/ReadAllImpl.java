package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.usecase.crud.ReadAllUseCase;

/**
 * <h1>Read All Models Use Case Implementation</h1>
 *
 * @param crudRepositoryPort The CRUD repository port for database operations
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record ReadAllImpl<M>(CrudRepositoryPort<M, ?> crudRepositoryPort) implements ReadAllUseCase<M> {

    @Override
    public java.util.List<M> getAll(int pageIndex, int pageSize) {
        return this.crudRepositoryPort.findAll(pageIndex, pageSize);
    }

}
