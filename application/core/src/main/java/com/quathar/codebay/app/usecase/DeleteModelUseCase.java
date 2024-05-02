package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.in.DeleteModelUseCasePort;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Delete Model Use Case Implementation</h1>
 *
 * @param <ID> The domain model identifier type.
 *
 * @see DeleteModelUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteModelUseCase<ID> implements DeleteModelUseCasePort<ID> {

    // <<-FIELD->>
    /**
     * The CRUD repository port.
     */
    @NonNull
    private final CrudRepositoryPort<?, ID> crudRepositoryPort;

    // <<-METHOD->>
    @Override
    public void deleteById(ID id) {
        this.crudRepositoryPort.deleteById(id);
    }

}
