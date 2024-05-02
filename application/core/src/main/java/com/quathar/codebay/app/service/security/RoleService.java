package com.quathar.codebay.app.service.security;

import com.quathar.codebay.app.service.CrudService;
import com.quathar.codebay.domain.model.security.Role;

import lombok.experimental.SuperBuilder;

/**
 * <h1>Role Service</h1>
 *
 * @see CrudService
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class RoleService
       extends     CrudService<Role, java.util.UUID> {
}
