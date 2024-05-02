package com.quathar.codebay.app.rest.security.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * <h1>Role Response</h1>
 *
 * @param id                 The ID of the granted permission.
 * @param name               The role unique name
 * @param description        The role description.
 * @param grantedPermissions The granted permissions of the role.
 *
 * @since 2024-04-27
 * @version 1.0
 * @author Q
 */
public record RoleResponse(
        UUID                            id,
        String                          name,
        String                          description,
        @JsonInclude(NON_NULL)
        List<GrantedPermissionResponse> grantedPermissions
) {}
