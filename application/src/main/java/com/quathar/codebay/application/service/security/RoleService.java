package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.RoleServicePort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.security.Role;

/**
 * <h1>Role Service</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public class      RoleService
       extends    CrudService<Role, java.util.UUID>
       implements RoleServicePort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a RoleService with the specified RoleRepositoryPort.
     *
     * @param roleRepositoryPort The port for role repository.
     */
    public RoleService(RoleRepositoryPort roleRepositoryPort) {
        super(roleRepositoryPort);
    }

}
