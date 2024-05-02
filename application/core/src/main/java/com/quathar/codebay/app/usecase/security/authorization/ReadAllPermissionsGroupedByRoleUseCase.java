package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.in.security.permission.ReadAllPermissionsGroupedByRoleUseCasePort;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

/**
 * <h1>Read All Grouped by Role Use Case Implementation</h1>
 *
 * @see ReadAllPermissionsGroupedByRoleUseCasePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadAllPermissionsGroupedByRoleUseCase implements ReadAllPermissionsGroupedByRoleUseCasePort {

    // <<-FIELD->>
    /**
     * The permission repository port.
     */
    @NonNull
    private final PermissionRepositoryPort permissionRepositoryPort;

    // <<-METHODS->>
    @Override
    public Stream<RoleOperations> getAllGroupedByRole() {
        /*
            Unlike the paging method, the result is obtained directly from the repository port (i.e. database),
            although some mapping work has to be done on the adapter,
            the time may be slightly better.
         */
        return this.permissionRepositoryPort.findAllGroupedByRole();
    }

    /**
     * Collects the operation names from a GrantedPermission stream.
     * <p>
     * Example of what the collector will do:
     * <pre>
     * Input:  {@code Stream<GrantedPermission>}
     * Output: {@code Stream<String> operationNames}
     * </pre>
     * </p>
     *
     * @return A collector that collects the operation names from a GrantedPermission stream
     */
    private Collector<
            GrantedPermission,
            ?,
            Stream<String>
    > collectOperationNames() {
        // The mapping(...) method will eventually return a Set<String>
        // so we get a Stream<String> with the 'Collection::stream' function
        return collectingAndThen(
                mapping(
                        permission -> permission
                                .getOperation()
                                .getName(),
                        toSet()
                ),
                java.util.Collection::stream
        );
    }

    /**
     * Collects RoleOperations objects from a GrantedPermission stream.
     * <p>
     * Example of what the collector will do:
     * <pre>
     * Input:  {@code Stream<GrantedPermission>}
     * Output: {@code Stream<RoleOperations>}
     * </pre>
     * </p>
     *
     * @return A collector that returns a RoleOperations stream from a GrantedPermission stream
     */
    private Collector<
            GrantedPermission,
            ?,
            Stream<RoleOperations>
    > collectToRoleOperations() {
        // We'll get a Map<String, Stream<String> eventually,
        // so we map it to Stream<RoleOperations>
        return collectingAndThen(
                groupingBy(
                        permission -> permission
                                .getRole()
                                .getName(),
                        this.collectOperationNames()
                ),
                resultMap -> resultMap
                        .entrySet()
                        .stream()
                        .map(entry -> RoleOperations.builder()
                                .role( entry.getKey() )
                                .operations( entry.getValue() )
                                .build()
                        )
        );
    }

    @Override
    public Stream<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize) {
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
              operations: [...] (stream of granted operations)
            }
         Unlike the no-paging method all this process is done on the server
         and could lead to a longer response time.
         */
        return this.permissionRepositoryPort
                .findAll( pageIndex, pageSize )
                .collect( this.collectToRoleOperations() );
    }

}
