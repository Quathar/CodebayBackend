package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.usecase.crud.DeleteModelUseCase;

/**
 * <h1>Delete Model Use Case Implementation</h1>
 *
 * @param crudRepositoryPort The CRUD repository port for database operations
 *
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record DeleteModelImpl<ID>(CrudRepositoryPort<?, ID> crudRepositoryPort) implements DeleteModelUseCase<ID> {

    @Override
    public void deleteById(ID id) {
        this.crudRepositoryPort.deleteById(id);
    }

}
