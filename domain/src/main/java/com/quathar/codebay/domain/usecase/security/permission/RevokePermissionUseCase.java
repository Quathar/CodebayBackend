package com.quathar.codebay.domain.usecase.security.permission;

/**
 * <h1>Revoke Permission Use Case</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface RevokePermissionUseCase {

    /**
     * Revokes the specified permission.
     *
     * @param grantedPermission The ID of the permission to revoke
     */
    void revoke(java.util.UUID grantedPermission);

}
