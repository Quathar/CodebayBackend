package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.usecase.security.permission.GrantPermissionUseCase;

/**
 * <h1>Grant Permission Use Case Implementation</h1>
 *
 * @param permissionRepositoryPort The permission repository port for managing permissions
 * @param roleRepositoryPort       The role repository port for managing roles
 * @param operationRepositoryPort  The operation repository port for managing operations
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record GrantPermissionImpl(
        PermissionRepositoryPort permissionRepositoryPort,
        RoleRepositoryPort       roleRepositoryPort,
        OperationRepositoryPort  operationRepositoryPort
) implements GrantPermissionUseCase {

    /**
     * Finds the role associated with the granted permission.
     *
     * @param grantedPermission The granted permission
     * @return The associated role
     * @throws ResourceNotFoundException if the role DOES NOT exist
     */
    private Role findRole(GrantedPermission grantedPermission) {
        return this.roleRepositoryPort
                .findByName( grantedPermission.getRole().getName() )
                .orElseThrow( () -> new ResourceNotFoundException("The role DOES NOT exist") );
    }

    /**
     * Finds the operation associated with the granted permission.
     *
     * @param grantedPermission The granted permission
     * @return The associated operation
     * @throws ResourceNotFoundException if the operation DOES NOT exist
     */
    private Operation findOperation(GrantedPermission grantedPermission) {
        return this.operationRepositoryPort
                .findByName( grantedPermission.getOperation().getName() )
                .orElseThrow( () -> new ResourceNotFoundException("The operation DOES NOT exist") );
    }

    @Override
    public GrantedPermission grant(GrantedPermission grantedPermission) {
        var permissionToBeGranted = GrantedPermission.builder()
                .role( this.findRole(grantedPermission) )
                .operation( this.findOperation(grantedPermission) )
                .build();
        return this.permissionRepositoryPort.save(permissionToBeGranted);
    }

}
