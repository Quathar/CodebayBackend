package com.quathar.codebay.application.inputport.security;

import com.quathar.codebay.application.inputport.CrudServicePort;
import com.quathar.codebay.domain.model.security.Role;

/**
 * <h1>Role Service Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface RoleServicePort extends CrudServicePort<Role, java.util.UUID> {
}
