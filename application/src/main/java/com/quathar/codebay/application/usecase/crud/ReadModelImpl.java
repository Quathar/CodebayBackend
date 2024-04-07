package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;

/**
 * <h1>Read Model Use Case Implementation</h1>
 *
 * @param crudRepositoryPort The CRUD repository port for database operations
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record ReadModelImpl<M, ID>(CrudRepositoryPort<M, ID> crudRepositoryPort) implements ReadModelUseCase<M, ID> {

    @Override
    public M getById(ID id) {
        return this.crudRepositoryPort
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
