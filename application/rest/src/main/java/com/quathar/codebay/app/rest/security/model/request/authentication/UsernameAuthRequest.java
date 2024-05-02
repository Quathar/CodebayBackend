package com.quathar.codebay.app.rest.security.model.request.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * <h1>Username Authentication Request</h1>
 *
 * Represents a request for authentication using a username and password.
 *
 * @param username The username of the user. Cannot be null or blank.
 * @param password The password of the user. Cannot be null or blank. Should adhere to a specific pattern.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public record UsernameAuthRequest(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
//        @Pattern(regexp = "")
        String password
) {}
