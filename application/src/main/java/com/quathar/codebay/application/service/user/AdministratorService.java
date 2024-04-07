package com.quathar.codebay.application.service.user;

import com.quathar.codebay.application.inputport.AdministratorServicePort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.domain.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadAllModelsUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.usecase.crud.UpdateModelUseCase;
import com.quathar.codebay.domain.usecase.user.DeleteByUsernameUseCase;
import com.quathar.codebay.domain.usecase.user.ReadByUsernameUseCase;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * <h1>Administrator Service</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class AdministratorService
       extends     CrudService<Administrator, UUID>
       implements  AdministratorServicePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<Administrator>   readAllUseCase;
    @NonNull private final ReadModelUseCase<Administrator, UUID> readUseCase;
    @NonNull private final ReadByUsernameUseCase<Administrator>  readByUsernameUseCase;
    @NonNull private final CreateModelUseCase<Administrator>     createUseCase;
    @NonNull private final UpdateModelUseCase<Administrator>     updateUseCase;
    @NonNull private final DeleteModelUseCase<UUID>              deleteUseCase;
    @NonNull private final DeleteByUsernameUseCase               deleteByUsernameUseCase;

    // <<-METHODS->>
    @Override
    public Administrator getByUsername(String username) {
        return this.readByUsernameUseCase.getByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        this.deleteByUsernameUseCase.deleteByUsername(username);
    }

}
