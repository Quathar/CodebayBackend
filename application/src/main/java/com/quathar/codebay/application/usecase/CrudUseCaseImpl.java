package com.quathar.codebay.application.usecase;

import com.quathar.codebay.application.inputport.crud.CrudUseCase;
import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;

/**
 * <h1>CRUD Use Case Implementation</h1>
 *
 * @param <M> The domain model
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class CrudUseCaseImpl<M, ID> implements CrudUseCase<M, ID> {

    // <<-FIELD->>
    private final CrudRepositoryPort<M, ID> crudRepositoryPort;

    // <<-CONSTRUCTOR->>
    public CrudUseCaseImpl(CrudRepositoryPort<M, ID> crudRepositoryPort) {
        this.crudRepositoryPort = crudRepositoryPort;
    }

    // <<-METHODS->>
    @Override
    public M create(M model) {
        return this.crudRepositoryPort.save(model);
    }

    @Override
    public M getById(ID id) {
        return this.crudRepositoryPort.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public M update(M model) {
        return this.crudRepositoryPort.update(model);
    }

    @Override
    public boolean deleteById(ID id) {
        return this.crudRepositoryPort.deleteById(id);
    }

}
