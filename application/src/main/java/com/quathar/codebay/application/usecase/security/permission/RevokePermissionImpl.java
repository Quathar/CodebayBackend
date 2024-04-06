package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.usecase.security.permission.RevokePermissionUseCase;

/**
 * <h1>Revoke Permission Use Case Implementation</h1>
 *
 * @param permissionRepositoryPort The permission repository port for managing permissions
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record RevokePermissionImpl(PermissionRepositoryPort permissionRepositoryPort) implements RevokePermissionUseCase {

    @Override
    public void revoke(java.util.UUID id) {
        this.permissionRepositoryPort.deleteById(id);
    }

}
