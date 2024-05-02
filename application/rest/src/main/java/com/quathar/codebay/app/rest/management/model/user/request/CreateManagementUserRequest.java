package com.quathar.codebay.app.rest.management.model.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * <h1>Create Management User Request</h1>
 *
 * @param username The username of the user. Cannot be null or blank.
 * @param password The password of the user. Cannot be null or blank. Should adhere to a specific pattern.
 * @param nickname The nickname of the user. Cannot be null or blank.
 * @param email    The email address of the user. Cannot be null or blank. Should adhere to a specific pattern.
 * @param status   The status of the user. Cannot be blank.
 * @param role     The role of the user. Cannot be blank.
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
public record CreateManagementUserRequest(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @NotNull
        @NotBlank
        String nickname,
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email,
        @NotBlank
        String status,
        @NotBlank
        String role
) {}
