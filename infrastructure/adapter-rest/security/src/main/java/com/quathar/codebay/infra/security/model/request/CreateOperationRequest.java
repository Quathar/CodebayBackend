package com.quathar.codebay.infra.security.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Create Operation Request</h1>
 *
 * Represents a request to create a new operation.
 *
 * @param name The name of the operation. It cannot be null or blank.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record CreateOperationRequest(
        @NotNull
        @NotBlank
        String name
) {}
