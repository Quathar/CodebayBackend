package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.domain.usecase.security.permission.ReadAllPermissionsGroupedByRoleUseCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Read All Grouped by Role Use Case Implementation</h1>
 *
 * @param permissionRepositoryPort The permission repository port for managing permissions
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record ReadAllGroupedByRoleImpl(PermissionRepositoryPort permissionRepositoryPort) implements ReadAllPermissionsGroupedByRoleUseCase {

    @Override
    public List<RoleOperations> getAllGroupedByRole() {
        /*
            Unlike the paging method, the result is obtained directly from the repository port (i.e. database),
            although some mapping work has to be done on the adapter,
            the time may be slightly better.
         */
        return this.permissionRepositoryPort.findAllGroupedByRole();
    }

    @Override
    public List<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize) {
        /*
        Here we get all the granted permissions paginated
        then we map those results that has this structure
            {
              granted_permission_id: ...
              role                 : {...}
              operation            : {...}
            }
        to this structure:
            {
              role      : ...   (name of the role)
              operations: [...] (list of granted operations)
            }
         Unlike the no-paging method all this process is done on the server
         and could lead to a longer response time.
         */
        return this.permissionRepositoryPort
                .findAll(pageIndex, pageSize)
                .stream()
                .collect(Collectors.groupingBy(
                        permission -> permission.getRole().getName(),
                        Collectors.mapping(
                                permission -> permission.getOperation().getName(),
                                Collectors.toSet()
                        )
                ))
                .entrySet()
                .stream()
                .map(entry -> RoleOperations.builder()
                        .role( entry.getKey() )
                        .operations( entry.getValue() )
                        .build()
                )
                .toList();
    }

}
