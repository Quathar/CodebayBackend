package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.usecase.crud.UpdateUseCase;

/**
 * <h1>Update Model Use Case Implementation</h1>
 *
 * @param crudRepositoryPort The CRUD repository port for database operations
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record UpdateImpl<M>(CrudRepositoryPort<M, ?> crudRepositoryPort) implements UpdateUseCase<M> {

    @Override
    public M update(M model) {
        return this.crudRepositoryPort.update(model);
    }

}
