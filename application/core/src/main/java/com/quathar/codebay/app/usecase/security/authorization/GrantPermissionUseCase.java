package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.in.security.permission.GrantPermissionUseCasePort;
import com.quathar.codebay.domain.port.out.security.OperationRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Grant Permission Use Case Implementation</h1>
 *
 * @see GrantPermissionUseCasePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class GrantPermissionUseCase implements GrantPermissionUseCasePort {

    // <<-FIELDS->>
    /**
     * The permission repository port.
     */
    @NonNull
    private final PermissionRepositoryPort permissionRepositoryPort;
    /**
     * The role repository port.
     */
    @NonNull
    private final RoleRepositoryPort roleRepositoryPort;
    /**
     * The operation repository port.
     */
    @NonNull
    private final OperationRepositoryPort operationRepositoryPort;

    // <<-METHODS->>
    /**
     * Finds the role associated with the specified name.
     *
     * @param roleName The granted permission
     * @return The associated role
     * @throws ModelNotFoundException if the role DOES NOT exist
     */
    private Role findRole(String roleName) {
        return this.roleRepositoryPort
                .findByName(roleName)
                .orElseThrow(() -> new ModelNotFoundException("The role DOES NOT exist"));
    }

    /**
     * Finds the operation associated with the specified name.
     *
     * @param operationName The operation name
     * @return The associated operation
     * @throws ModelNotFoundException if the operation DOES NOT exist
     */
    private Operation findOperation(String operationName) {
        return this.operationRepositoryPort
                .findByName(operationName)
                .orElseThrow(() -> new ModelNotFoundException("The operation DOES NOT exist"));
    }

    @Override
    public GrantedPermission grant(String roleName, String operationName) {
        var permissionToBeGranted = GrantedPermission.builder()
                .role( this.findRole(roleName) )
                .operation( this.findOperation(operationName) )
                .build();
        return this.permissionRepositoryPort.save(permissionToBeGranted);
    }

}
