package com.quathar.codebay.infra.rest.security.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * <h1>Email Authentication Request</h1>
 *
 * Represents a request for authentication using email and password.
 *
 * @param email    The email address of the user. Must adhere to a valid email pattern.
 * @param password The password of the user. Cannot be null or blank.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public record EmailAuthRequest(
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email,
        @NotNull
        @NotBlank
        String password
) {}
