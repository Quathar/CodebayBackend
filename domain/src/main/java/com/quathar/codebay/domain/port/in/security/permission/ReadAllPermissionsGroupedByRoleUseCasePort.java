package com.quathar.codebay.domain.port.in.security.permission;

import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import java.util.stream.Stream;

/**
 * <h1>Read All Permissions grouped by Role Use Case</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface ReadAllPermissionsGroupedByRoleUseCasePort {

    /**
     * Retrieves all roles grouped by their operations.
     *
     * @return A list of {@link RoleOperations} models, each representing a role with its operations.
     */
    Stream<RoleOperations> getAllGroupedByRole();

    /**
     * Retrieves all roles grouped by their operations, paginated.
     *
     * @param pageIndex The index of the page to retrieve.
     * @param pageSize  The size of the page.
     * @return A list of {@link RoleOperations} models, each representing a role with its operations.
     */
    Stream<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize);

}
