package com.quathar.codebay.domain.port.out.security;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

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
    java.util.stream.Stream<RoleOperations> findAllGroupedByRole();

}
