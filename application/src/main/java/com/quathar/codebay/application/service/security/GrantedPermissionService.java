package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.GrantedPermissionServicePort;
import com.quathar.codebay.application.outputport.security.GrantedPermissionRepositoryPort;
import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.model.security.RoleOperations;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Granted Permission Service</h1>
 *
 * Service for managing granted permissions.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public class      GrantedPermissionService
       extends    CrudService<GrantedPermission, java.util.UUID>
       implements GrantedPermissionServicePort {

    // <<-FIELDS->>
    /**
     * The granted permission repository port.
     */
    private final GrantedPermissionRepositoryPort grantedPermissionRepositoryPort;
    /**
     * The role repository port.
     */
    private final RoleRepositoryPort roleRepositoryPort;
    /**
     * The operation repository port.
     */
    private final OperationRepositoryPort operationRepositoryPort;

    // <<-CONSTRUCTOR->>
    /**
     *
     * Constructs a GrantedPermissionService with the specified ports.
     *
     * @param grantedPermissionRepositoryPort The port for granted permission repository.
     * @param roleRepositoryPort              The port for role repository.
     * @param operationRepositoryPort         The port for operation repository.
     */
    public GrantedPermissionService(
            GrantedPermissionRepositoryPort grantedPermissionRepositoryPort,
            RoleRepositoryPort              roleRepositoryPort,
            OperationRepositoryPort         operationRepositoryPort
    ) {
        super(grantedPermissionRepositoryPort);
        this.grantedPermissionRepositoryPort = grantedPermissionRepositoryPort;
        this.roleRepositoryPort              = roleRepositoryPort;
        this.operationRepositoryPort         = operationRepositoryPort;
    }

    // <<-METHODS->>
    @Override
    public List<RoleOperations> getAllGroupedByRole() {
        /*
        Unlike the paging method, the result is obtained directly from the repository port (i.e. database),
        although some mapping work has to be done on the adapter,
        the time may be slightly better.
         */
        return this.grantedPermissionRepositoryPort.findAllGroupedByRole();
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
        return this.grantedPermissionRepositoryPort
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

    @Override
    public GrantedPermission create(GrantedPermission grantedPermission) {
        Role role = this.roleRepositoryPort
                .findByName( grantedPermission.getRole().getName() )
                .orElseThrow( () -> new ResourceNotFoundException("The role DOES NOT exist") );
        Operation operation = this.operationRepositoryPort
                .findByName( grantedPermission.getOperation().getName() )
                .orElseThrow( () -> new ResourceNotFoundException("The operation DOES NOT exist") );

        GrantedPermission permissionToBeGranted = GrantedPermission.builder()
                .role( role )
                .operation( operation )
                .build();
        return this.grantedPermissionRepositoryPort.save(permissionToBeGranted);
    }

}
