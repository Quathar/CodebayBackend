package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.CrudServicePort;
import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;

/**
 * <h1>CRUD Service</h1>
 * <br>
 * <p>
 *     This service provides CRUD (Create, Read, Update, Delete) operations for a specified domain model.
 * </p>
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class CrudService<M, ID> implements CrudServicePort<M, ID> {

    // <<-FIELD->>
    /**
     * The port providing access to CRUD operations for the specified domain model.
     */
    private final CrudRepositoryPort<M, ID> crudRepositoryPort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a CrudService with the provided CrudRepositoryPort.
     *
     * @param crudRepositoryPort The port providing access to CRUD operations for the specified domain model.
     */
    public CrudService(CrudRepositoryPort<M, ID> crudRepositoryPort) {
        this.crudRepositoryPort = crudRepositoryPort;
    }

    // <<-METHODS->>
    @Override
    public java.util.List<M> getAll(int pageNumber, int pageSize) {
        return this.crudRepositoryPort.findAll(pageNumber, pageSize);
    }

    @Override
    public M getById(ID id) throws ResourceNotFoundException {
        return this.crudRepositoryPort.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public M create(M model) {
        return this.crudRepositoryPort.save(model);
    }

    @Override
    public M update(M model) {
        return this.crudRepositoryPort.update(model);
    }

    @Override
    public Boolean deleteById(ID id) {
        return this.crudRepositoryPort.deleteById(id);
    }

}
