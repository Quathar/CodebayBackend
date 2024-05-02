package com.quathar.codebay.app.rest.security.model.request.authorization;

import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Update Role Request</h1>
 *
 * Represents a request to update a role.
 *
 * @param name        The name of the operation. It cannot be blank.
 * @param description The description of the operation. It cannot be blank.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record UpdateRoleRequest(
        @NotBlank
        String name,
        @NotBlank
        String description
) {}
