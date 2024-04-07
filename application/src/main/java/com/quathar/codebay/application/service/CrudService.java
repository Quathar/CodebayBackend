package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.CrudServicePort;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.domain.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadAllModelsUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.usecase.crud.UpdateModelUseCase;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * <h1>CRUD Service</h1>
 *
 * This service provides CRUD (Create, Read, Update, Delete) operations for a specified domain model.
 *
 * @param <M>  The domain model
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public abstract class CrudService<M, ID> implements CrudServicePort<M, ID> {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<M> readAllUseCase;
    @NonNull private final ReadModelUseCase<M, ID> readUseCase;
    @NonNull private final CreateModelUseCase<M>   createUseCase;
    @NonNull private final UpdateModelUseCase<M>   updateUseCase;
    @NonNull private final DeleteModelUseCase<ID>  deleteUseCase;

    // <<-METHODS->>
    @Override
    public java.util.List<M> getAll(int pageIndex, int pageSize) {
        return this.readAllUseCase.getAll(pageIndex, pageSize);
    }

    @Override
    public M getById(ID id) {
        return this.readUseCase.getById(id);
    }

    @Override
    public M create(M model) {
        return this.createUseCase.create(model);
    }

    @Override
    public M update(M model) {
        return this.updateUseCase.update(model);
    }

    @Override
    public void deleteById(ID id) {
        this.deleteUseCase.deleteById(id);
    }

}
