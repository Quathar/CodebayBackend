package com.quathar.codebay.application.service.user;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.User;
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
 * <h1>User Service</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class UserService
       extends     CrudService<User, UUID>
       implements  UserServicePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<User>   readAllUseCase;
    @NonNull private final ReadModelUseCase<User, UUID> readUseCase;
    @NonNull private final CreateModelUseCase<User>     createUseCase;
    @NonNull private final UpdateModelUseCase<User>     updateUseCase;
    @NonNull private final DeleteModelUseCase<UUID>     deleteUseCase;
    @NonNull private final ReadByUsernameUseCase<User>  readByUsernameUseCase;
    @NonNull private final DeleteByUsernameUseCase      deleteByUsernameUseCase;

    // <<-METHODS->>
    @Override
    public User getByUsername(String username) {
        return this.readByUsernameUseCase.getByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        this.deleteByUsernameUseCase.deleteByUsername(username);
    }

}
