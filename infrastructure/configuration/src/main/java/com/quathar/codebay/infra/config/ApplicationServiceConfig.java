package com.quathar.codebay.infra.config;

import com.quathar.codebay.app.service.user.AdministratorService;
import com.quathar.codebay.app.service.user.UserService;
import com.quathar.codebay.app.usecase.DeleteModelUseCase;
import com.quathar.codebay.app.usecase.ReadAllModelsUseCase;
import com.quathar.codebay.app.usecase.ReadModelUseCase;
import com.quathar.codebay.app.usecase.UpdateModelUseCase;
import com.quathar.codebay.app.usecase.user.CreateAdminUseCase;
import com.quathar.codebay.app.usecase.user.CreateUserUseCase;
import com.quathar.codebay.app.usecase.user.DeleteAdminById;
import com.quathar.codebay.app.usecase.user.DeleteAdminByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.DeleteUserByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.ReadAdminByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.ReadUserByUsernameUseCase;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Application Service Configuration</h1>
 *
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
@Configuration
public class ApplicationServiceConfig {

    @Bean
    public UserService userService(
            UserRepositoryPort  userRepositoryPort,
            RoleRepositoryPort  roleRepositoryPort,
            PasswordServicePort passwordServicePort
    ) {
        return UserService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(userRepositoryPort) )
                .readUseCase( new ReadModelUseCase<>(userRepositoryPort) )
                .readByUsernameUseCase( new ReadUserByUsernameUseCase(userRepositoryPort) )
                .createUseCase( new CreateUserUseCase(userRepositoryPort, roleRepositoryPort, passwordServicePort) )
                .updateUseCase( new UpdateModelUseCase<>(userRepositoryPort) )
                .deleteUseCase( new DeleteModelUseCase<>(userRepositoryPort) )
                .deleteByUsernameUseCase( new DeleteUserByUsernameUseCase(userRepositoryPort) )
                .seal();
    }

    @Bean
    public AdministratorService adminService(
            AdministratorRepositoryPort adminRepositoryPort,
            RoleRepositoryPort          roleRepositoryPort,
            PasswordServicePort         passwordServicePort
    ) {
        return AdministratorService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(adminRepositoryPort) )
                .readUseCase( new ReadModelUseCase<>(adminRepositoryPort) )
                .readByUsernameUseCase( new ReadAdminByUsernameUseCase(adminRepositoryPort) )
                .createUseCase( new CreateAdminUseCase(adminRepositoryPort, roleRepositoryPort, passwordServicePort) )
                .updateUseCase( new UpdateModelUseCase<>(adminRepositoryPort) )
                .deleteUseCase( new DeleteAdminById(adminRepositoryPort) )
                .deleteByUsernameUseCase( new DeleteAdminByUsernameUseCase(adminRepositoryPort) )
                .seal();
    }

}
