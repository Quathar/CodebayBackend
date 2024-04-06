package com.quathar.codebay.application.outputport.security;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;

/**
 * <h1>Permission Repository Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface PermissionRepositoryPort extends CrudRepositoryPort<GrantedPermission, java.util.UUID> {

    /**
     * Finds a list of roles with its associated operations.
     *
     * @return A list of {@link RoleOperations} representing roles and associated operations.
     */
    java.util.List<RoleOperations> findAllGroupedByRole();

}
