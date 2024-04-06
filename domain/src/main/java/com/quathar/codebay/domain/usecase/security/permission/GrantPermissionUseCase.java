package com.quathar.codebay.domain.usecase.security.permission;

import com.quathar.codebay.domain.model.security.GrantedPermission;

/**
 * <h1>Grant Permission Use Case</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface GrantPermissionUseCase {

    /**
     * Grants the specified permission.
     *
     * @param grantedPermission The permission to grant
     * @return The granted permission
     */
    GrantedPermission grant(GrantedPermission grantedPermission);

}
