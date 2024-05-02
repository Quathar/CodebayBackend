package com.quathar.codebay.app.rest.security.model.request.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

/**
 * <h1>Id Authentication Request</h1>
 *
 * Represents a request for authentication using id and password.
 *
 * @param id       The user ID. Cannot be null or blank.
 * @param password The password of the user. Cannot be null or blank. Should adhere to a specific pattern.
 *
 * @since 2024-03
 * @version 1.0
 * @author Q
 */
public record IdAuthenticationRequest(
        @NotNull
        @NotBlank
        UUID id,
        @NotNull
        @NotBlank
//        @Pattern(regexp = "")
        String password
) {}
