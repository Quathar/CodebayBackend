package com.quathar.codebay.infra.rest.common.config;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.inputport.security.PasswordServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.application.service.user.UserService;
import com.quathar.codebay.application.usecase.crud.DeleteModelImpl;
import com.quathar.codebay.application.usecase.user.DeleteUserByUsername;
import com.quathar.codebay.application.usecase.crud.ReadAllModelsImpl;
import com.quathar.codebay.application.usecase.crud.ReadModelImpl;
import com.quathar.codebay.application.usecase.crud.UpdateModelImpl;
import com.quathar.codebay.application.usecase.user.CreateUser;
import com.quathar.codebay.application.usecase.user.ReadUserByUsername;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Common Service Port Configuration</h1>
 *
 * This configuration class provides methods to create
 * and configure common input service ports for the application services.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Configuration
@ComponentScan("com.quathar.codebay.infra.jpa")
public class CommonServicePortConfig {

    // <<-BEAN->>
    @Bean
    public UserServicePort userServicePort(
            UserRepositoryPort  userRepositoryPort,
            RoleRepositoryPort  roleRepositoryPort,
            PasswordServicePort passwordServicePort
    ) {
        return UserService.setup()
                .readAllUseCase( new ReadAllModelsImpl<>(userRepositoryPort) )
                .readUseCase( new ReadModelImpl<>(userRepositoryPort) )
                .readByUsernameUseCase( new ReadUserByUsername(userRepositoryPort) )
                .createUseCase( new CreateUser(userRepositoryPort, roleRepositoryPort, passwordServicePort) )
                .updateUseCase( new UpdateModelImpl<>(userRepositoryPort) )
                .deleteUseCase( new DeleteModelImpl<>(userRepositoryPort) )
                .deleteByUsernameUseCase( new DeleteUserByUsername(userRepositoryPort) )
                .seal();
    }

}
