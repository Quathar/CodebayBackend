package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.port.in.security.permission.RevokePermissionUseCasePort;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Revoke Permission Use Case Implementation</h1>
 *
 * @see RevokePermissionUseCasePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class RevokePermissionUseCase implements RevokePermissionUseCasePort {

    // <<-FIELD->>
    /**
     * The permission repository port.
     */
    @NonNull
    private final PermissionRepositoryPort permissionRepositoryPort;

    // <<-METHOD->>
    @Override
    public void revoke(java.util.UUID id) {
        this.permissionRepositoryPort.deleteById(id);
    }

}
