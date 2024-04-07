package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.OperationServicePort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.domain.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadAllModelsUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.usecase.crud.UpdateModelUseCase;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * <h1>Operation Service</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class OperationService
       extends     CrudService<Operation, UUID>
       implements  OperationServicePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<Operation>   readAllUseCase;
    @NonNull private final ReadModelUseCase<Operation, UUID> readUseCase;
    @NonNull private final CreateModelUseCase<Operation>     createUseCase;
    @NonNull private final UpdateModelUseCase<Operation>     updateUseCase;
    @NonNull private final DeleteModelUseCase<UUID>          deleteUseCase;

}
