package com.quathar.codebay.infra.security.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Create Role Request</h1>
 *
 * Represents a request to create a new operation.
 *
 * @param name        The name of the operation. It cannot be null or blank.
 * @param description The description of the operation. It cannot be null or blank.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record CreateRoleRequest(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String description
) {}
