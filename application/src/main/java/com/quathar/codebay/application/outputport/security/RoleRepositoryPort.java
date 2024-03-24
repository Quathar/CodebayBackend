package com.quathar.codebay.application.outputport.security;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.model.security.Role;

/**
 * <h1>Role Repository Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface RoleRepositoryPort extends CrudRepositoryPort<Role, java.util.UUID> {

    /**
     * Finds a role by its name.
     *
     * @param roleName The name of the role to find.
     * @return An Optional containing the found role, or empty if not found.
     */
    java.util.Optional<Role> findByName(String roleName);

}
