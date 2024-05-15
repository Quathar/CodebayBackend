package com.quathar.codebay.app.service.user;

import com.quathar.codebay.app.service.CrudService;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.DeleteByUsernameUseCasePort;
import com.quathar.codebay.domain.port.in.user.ReadByUsernameUseCasePort;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * <h1>Common User Service</h1>
 *
 * @param <M> The user type
 *
 * @see CrudService
 * @see ReadByUsernameUseCasePort
 * @see DeleteByUsernameUseCasePort
 * @since 2024-04-14
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public sealed class CommonUserService<M extends User>
       extends      CrudService<M, java.util.UUID>
       implements   ReadByUsernameUseCasePort<M>,
                    DeleteByUsernameUseCasePort
       permits      UserService,
                    AdministratorService,
                    CustomerService {

    // <<-FIELDS->>
    @NonNull protected final ReadByUsernameUseCasePort<M> readByUsernameUseCase;
    @NonNull protected final DeleteByUsernameUseCasePort  deleteByUsernameUseCase;

    // <<-METHODS->>
    @Override
    public M getByUsername(String username) {
        return this.readByUsernameUseCase.getByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        this.deleteByUsernameUseCase.deleteByUsername(username);
    }

}
