package com.quathar.codebay.infra.rest.security.config;

import com.quathar.codebay.application.inputport.security.GrantedPermissionServicePort;
import com.quathar.codebay.application.inputport.security.OperationServicePort;
import com.quathar.codebay.application.inputport.security.RoleServicePort;
import com.quathar.codebay.application.outputport.security.GrantedPermissionRepositoryPort;
import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.application.service.security.GrantedPermissionService;
import com.quathar.codebay.application.service.security.OperationService;
import com.quathar.codebay.application.service.security.RoleService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Security Input Adapter Configuration</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Configuration
public class SecurityInputAdapterConfig {

    // <<-BEANS->>
    @Bean
    public RoleServicePort roleServicePort(RoleRepositoryPort roleRepositoryPort) {
        return new RoleService(roleRepositoryPort);
    }

    @Bean
    public OperationServicePort operationServicePort(OperationRepositoryPort operationRepositoryPort) {
        return new OperationService(operationRepositoryPort);
    }

    @Bean
    public GrantedPermissionServicePort grantedPermissionServicePort(
            GrantedPermissionRepositoryPort grantedPermissionRepositoryPort,
            RoleRepositoryPort              roleRepositoryPort,
            OperationRepositoryPort         operationRepositoryPort
    ) {
        return new GrantedPermissionService(
                grantedPermissionRepositoryPort,
                roleRepositoryPort,
                operationRepositoryPort
        );
    }

}
