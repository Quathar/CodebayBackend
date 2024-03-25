package com.quathar.codebay.infra.security.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Id Authentication Request</h1>
 *
 * Represents a request for authentication using id and password.
 *
 * @param id       The user ID. Cannot be null or blank.
 * @param password The password of the user. Cannot be null or blank.
 *
 * @since 2024-03
 * @version 1.0
 * @author Q
 */
public record IdAuthenticationRequest(
        @NotNull
        @NotBlank
        java.util.UUID id,
        @NotNull
        @NotBlank
        String password
) {}
