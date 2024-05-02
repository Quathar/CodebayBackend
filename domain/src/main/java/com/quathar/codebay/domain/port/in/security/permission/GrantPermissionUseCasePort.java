package com.quathar.codebay.domain.port.in.security.permission;

import com.quathar.codebay.domain.model.security.GrantedPermission;

/**
 * <h1>Grant Permission Use Case</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface GrantPermissionUseCasePort {

    /**
     * Grants the specified permission.
     *
     * @param roleName The role name
     * @param operationName The operation name
     * @return The granted permission
     */
    GrantedPermission grant(String roleName, String operationName);

}
