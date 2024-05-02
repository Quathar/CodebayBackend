package com.quathar.codebay.app.service.security;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.in.ReadAllModelsUseCasePort;
import com.quathar.codebay.domain.port.in.ReadModelUseCasePort;
import com.quathar.codebay.domain.port.in.security.permission.GrantPermissionUseCasePort;
import com.quathar.codebay.domain.port.in.security.permission.ReadAllPermissionsGroupedByRoleUseCasePort;
import com.quathar.codebay.domain.port.in.security.permission.RevokePermissionUseCasePort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Permission Service</h1>
 *
 * Service for managing permissions.
 *
 * @see ReadAllModelsUseCasePort
 * @see ReadAllPermissionsGroupedByRoleUseCasePort
 * @see ReadModelUseCasePort
 * @see GrantPermissionUseCasePort
 * @see RevokePermissionUseCasePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class PermissionService
       implements  ReadAllModelsUseCasePort<GrantedPermission>,
                   ReadAllPermissionsGroupedByRoleUseCasePort,
                   ReadModelUseCasePort<GrantedPermission, UUID>,
                   GrantPermissionUseCasePort,
                   RevokePermissionUseCasePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCasePort<GrantedPermission>   readAllUseCase;
    @NonNull private final ReadAllPermissionsGroupedByRoleUseCasePort    readAllPermissionsGroupedByRoleUseCase;
    @NonNull private final ReadModelUseCasePort<GrantedPermission, UUID> readUseCase;
    @NonNull private final GrantPermissionUseCasePort                    grantPermissionUseCase;
    @NonNull private final RevokePermissionUseCasePort                   revokePermissionUseCase;

    // <<-METHODS->>
    @Override
    public Stream<GrantedPermission> getAll(int pageIndex, int pageSize) {
        return this.readAllUseCase.getAll(pageIndex, pageSize);
    }

    @Override
    public Stream<RoleOperations> getAllGroupedByRole() {
        return this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole();
    }

    @Override
    public Stream<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize) {
        return this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole(pageIndex, pageSize);
    }

    @Override
    public GrantedPermission getById(UUID id) {
        return this.readUseCase.getById(id);
    }

    @Override
    public GrantedPermission grant(String roleName, String operationName) {
        return this.grantPermissionUseCase.grant(roleName, operationName);
    }

    @Override
    public void revoke(UUID grantedPermissionId) {
        this.revokePermissionUseCase.revoke(grantedPermissionId);
    }

}
