package com.quathar.codebay.app.service;

import com.quathar.codebay.domain.port.in.CreateModelUseCasePort;
import com.quathar.codebay.domain.port.in.DeleteModelUseCasePort;
import com.quathar.codebay.domain.port.in.ReadAllModelsUseCasePort;
import com.quathar.codebay.domain.port.in.ReadModelUseCasePort;
import com.quathar.codebay.domain.port.in.UpdateModelUseCasePort;

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
 * @see ReadAllModelsUseCasePort
 * @see ReadModelUseCasePort
 * @see CreateModelUseCasePort
 * @see UpdateModelUseCasePort
 * @see DeleteModelUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public abstract class CrudService<M, ID>
       implements     CreateModelUseCasePort<M>,
                      ReadAllModelsUseCasePort<M>,
                      ReadModelUseCasePort<M, ID>,
                      UpdateModelUseCasePort<M>,
                      DeleteModelUseCasePort<ID> {

    // <<-FIELDS->>
    @NonNull protected final ReadAllModelsUseCasePort<M> readAllUseCase;
    @NonNull protected final ReadModelUseCasePort<M, ID> readUseCase;
    @NonNull protected final CreateModelUseCasePort<M>   createUseCase;
    @NonNull protected final UpdateModelUseCasePort<M>   updateUseCase;
    @NonNull protected final DeleteModelUseCasePort<ID>  deleteUseCase;

    // <<-METHODS->>
    @Override
    public java.util.stream.Stream<M> getAll(int pageIndex, int pageSize) {
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
