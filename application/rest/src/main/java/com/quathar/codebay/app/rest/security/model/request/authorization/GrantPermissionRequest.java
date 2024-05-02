package com.quathar.codebay.app.rest.security.model.request.authorization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Grant Permission Request</h1>
 *
 * Represents a request to grant a permission.
 *
 * @param role      The role to which the permission will be granted.
 * @param operation The operation for which permission will be granted.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record GrantPermissionRequest(
        @NotNull
        @NotBlank
        String role,
        @NotNull
        @NotBlank
        String operation
) {}
