package com.quathar.codebay.infra.rest.security.config;

import com.quathar.codebay.application.inputport.security.AuthenticationServicePort;
import com.quathar.codebay.application.inputport.security.JwtServicePort;
import com.quathar.codebay.application.inputport.security.OperationServicePort;
import com.quathar.codebay.application.inputport.security.PasswordServicePort;
import com.quathar.codebay.application.inputport.security.PermissionServicePort;
import com.quathar.codebay.application.inputport.security.RoleServicePort;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;

import com.quathar.codebay.application.service.security.AuthenticationService;
import com.quathar.codebay.application.service.security.JwtService;
import com.quathar.codebay.application.service.security.OperationService;
import com.quathar.codebay.application.service.security.PasswordService;
import com.quathar.codebay.application.service.security.PermissionService;
import com.quathar.codebay.application.service.security.RoleService;

import com.quathar.codebay.application.usecase.crud.CreateModelImpl;
import com.quathar.codebay.application.usecase.crud.DeleteModelImpl;
import com.quathar.codebay.application.usecase.crud.ReadAllModelsImpl;
import com.quathar.codebay.application.usecase.crud.ReadModelImpl;
import com.quathar.codebay.application.usecase.crud.UpdateModelImpl;
import com.quathar.codebay.application.usecase.security.permission.GrantPermissionImpl;
import com.quathar.codebay.application.usecase.security.permission.ReadAllGroupedByRoleImpl;
import com.quathar.codebay.application.usecase.security.permission.RevokePermissionImpl;

import com.quathar.codebay.infra.rest.security.usecase.AuthenticationImpl;
import com.quathar.codebay.infra.rest.security.usecase.ExtractUsername;
import com.quathar.codebay.infra.rest.security.usecase.GenerateTokenPair;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <h1>Security Input Adapter Configuration</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Configuration
public class SecurityServicePortConfig {

    // <<-BEANS->>
    @Bean
    public AuthenticationServicePort authenticationServicePort(AuthenticationImpl authenticationUseCase) {
        return AuthenticationService.setup()
                .authenticationUseCase(authenticationUseCase)
                .seal();
    }

    @Bean
    public JwtServicePort jwtServicePort(
            GenerateTokenPair generateTokenPair,
            ExtractUsername extractUsername
    ) {
        return JwtService.setup()
                .generateTokenPairUseCase(generateTokenPair)
                .extractUsernameUseCase(extractUsername)
                .seal();
    }

    @Bean
    public PasswordServicePort passwordServicePort(PasswordEncoder passwordEncoder) {
        return PasswordService.setup()
                .encodeUseCase(passwordEncoder::encode)
                .matchesUseCase(passwordEncoder::matches)
                .seal();
    }

    @Bean
    public RoleServicePort roleServicePort(RoleRepositoryPort repositoryPort) {
        return RoleService.setup()
                .readAllUseCase( new ReadAllModelsImpl<>(repositoryPort) )
                .readUseCase( new ReadModelImpl<>(repositoryPort)  )
                .createUseCase( new CreateModelImpl<>(repositoryPort) )
                .updateUseCase( new UpdateModelImpl<>(repositoryPort) )
                .deleteUseCase( new DeleteModelImpl<>(repositoryPort) )
                .seal();
    }

    @Bean
    public OperationServicePort operationServicePort(OperationRepositoryPort repositoryPort) {
        return OperationService.setup()
                .readAllUseCase( new ReadAllModelsImpl<>(repositoryPort) )
                .readUseCase( new ReadModelImpl<>(repositoryPort)  )
                .createUseCase( new CreateModelImpl<>(repositoryPort) )
                .updateUseCase( new UpdateModelImpl<>(repositoryPort) )
                .deleteUseCase( new DeleteModelImpl<>(repositoryPort) )
                .seal();
    }

    @Bean
    public PermissionServicePort grantedPermissionServicePort(
            PermissionRepositoryPort permissionRepositoryPort,
            RoleRepositoryPort       roleRepositoryPort,
            OperationRepositoryPort  operationRepositoryPort
    ) {
        return PermissionService.setup()
                .readAllUseCase( new ReadAllModelsImpl<>(permissionRepositoryPort) )
                .readAllPermissionsGroupedByRoleUseCase( new ReadAllGroupedByRoleImpl(permissionRepositoryPort) )
                .readUseCase( new ReadModelImpl<>(permissionRepositoryPort) )
                .grantPermissionUseCase( new GrantPermissionImpl(permissionRepositoryPort, roleRepositoryPort, operationRepositoryPort) )
                .revokePermissionUseCase( new RevokePermissionImpl(permissionRepositoryPort) )
                .seal();
    }

}
