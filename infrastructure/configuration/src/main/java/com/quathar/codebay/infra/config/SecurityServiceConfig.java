package com.quathar.codebay.infra.config;

import com.quathar.codebay.app.service.security.AuthenticationService;
import com.quathar.codebay.app.service.security.OperationService;
import com.quathar.codebay.app.service.security.PermissionService;
import com.quathar.codebay.app.service.security.RoleService;
import com.quathar.codebay.app.usecase.CreateModelUseCase;
import com.quathar.codebay.app.usecase.DeleteModelUseCase;
import com.quathar.codebay.app.usecase.ReadAllModelsUseCase;
import com.quathar.codebay.app.usecase.ReadModelUseCase;
import com.quathar.codebay.app.usecase.UpdateModelUseCase;
import com.quathar.codebay.app.usecase.security.authentication.AuthenticationUseCase;
import com.quathar.codebay.app.usecase.security.authentication.RefreshTokenUseCase;
import com.quathar.codebay.app.usecase.security.authorization.GrantPermissionUseCase;
import com.quathar.codebay.app.usecase.security.authorization.ReadAllPermissionsGroupedByRoleUseCase;
import com.quathar.codebay.app.usecase.security.authorization.RevokePermissionUseCase;
import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;
import com.quathar.codebay.domain.port.out.security.OperationRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Security Service Configuration</h1>
 *
 * @see AuthenticationService
 * @see RoleService
 * @see OperationService
 * @see PermissionService
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Configuration
public class SecurityServiceConfig {

    @Bean
    public AuthenticationService authenticationService(AuthenticationManagerPort authenticationManagerPort) {
        return AuthenticationService.setup()
                .authenticationUseCase( new AuthenticationUseCase(authenticationManagerPort) )
                .refreshTokenUseCase( new RefreshTokenUseCase(authenticationManagerPort) )
                .seal();
    }

    @Bean
    public RoleService roleService(RoleRepositoryPort repositoryPort) {
        return RoleService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(repositoryPort) )
                .readUseCase( new ReadModelUseCase<>(repositoryPort) )
                .createUseCase( new CreateModelUseCase<>(repositoryPort) )
                .updateUseCase( new UpdateModelUseCase<>(repositoryPort) )
                .deleteUseCase( new DeleteModelUseCase<>(repositoryPort) )
                .seal();
    }

    @Bean
    public OperationService operationService(OperationRepositoryPort repositoryPort) {
        return OperationService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(repositoryPort) )
                .readUseCase( new ReadModelUseCase<>(repositoryPort) )
                .createUseCase( new CreateModelUseCase<>(repositoryPort) )
                .updateUseCase( new UpdateModelUseCase<>(repositoryPort) )
                .deleteUseCase( new DeleteModelUseCase<>(repositoryPort) )
                .seal();
    }

    @Bean
    public PermissionService permissionService(
            PermissionRepositoryPort permissionRepositoryPort,
            RoleRepositoryPort       roleRepositoryPort,
            OperationRepositoryPort  operationRepositoryPort
    ) {
        return PermissionService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(permissionRepositoryPort) )
                .readUseCase( new ReadModelUseCase<>(permissionRepositoryPort) )
                .readAllPermissionsGroupedByRoleUseCase( new ReadAllPermissionsGroupedByRoleUseCase(permissionRepositoryPort) )
                .grantPermissionUseCase( new GrantPermissionUseCase(permissionRepositoryPort, roleRepositoryPort, operationRepositoryPort) )
                .revokePermissionUseCase( new RevokePermissionUseCase(permissionRepositoryPort) )
                .seal();
    }

}
