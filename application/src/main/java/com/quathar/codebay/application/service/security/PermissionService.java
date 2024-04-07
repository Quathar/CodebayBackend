package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.PermissionServicePort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.domain.usecase.crud.ReadAllModelsUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.usecase.security.permission.GrantPermissionUseCase;
import com.quathar.codebay.domain.usecase.security.permission.ReadAllPermissionsGroupedByRoleUseCase;
import com.quathar.codebay.domain.usecase.security.permission.RevokePermissionUseCase;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Permission Service</h1>
 *
 * Service for managing permissions.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class PermissionService implements PermissionServicePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllModelsUseCase<GrantedPermission>   readAllUseCase;
    @NonNull private final ReadAllPermissionsGroupedByRoleUseCase    readAllPermissionsGroupedByRoleUseCase;
    @NonNull private final ReadModelUseCase<GrantedPermission, UUID> readUseCase;
    @NonNull private final GrantPermissionUseCase                    grantPermissionUseCase;
    @NonNull private final RevokePermissionUseCase                   revokePermissionUseCase;

    // <<-METHODS->>
    @Override
    public List<GrantedPermission> getAll(int pageIndex, int pageSize) {
        return this.readAllUseCase.getAll(pageIndex, pageSize);
    }

    @Override
    public List<RoleOperations> getAllGroupedByRole() {
        return this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole();
    }

    @Override
    public List<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize) {
        return this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole(pageIndex, pageSize);
    }

    @Override
    public GrantedPermission getById(UUID id) {
        return this.readUseCase.getById(id);
    }

    @Override
    public GrantedPermission grant(GrantedPermission permission) {
        return this.grantPermissionUseCase.grant(permission);
    }

    @Override
    public void revoke(UUID grantedPermissionId) {
        this.revokePermissionUseCase.revoke(grantedPermissionId);
    }

}
