package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.RoleServicePort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.domain.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadAllModelsUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.usecase.crud.UpdateModelUseCase;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * <h1>Role Service</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class RoleService
       extends     CrudService<Role, UUID>
       implements  RoleServicePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<Role>   readAllUseCase;
    @NonNull private final ReadModelUseCase<Role, UUID> readUseCase;
    @NonNull private final CreateModelUseCase<Role>     createUseCase;
    @NonNull private final UpdateModelUseCase<Role>     updateUseCase;
    @NonNull private final DeleteModelUseCase<UUID>     deleteUseCase;

}
