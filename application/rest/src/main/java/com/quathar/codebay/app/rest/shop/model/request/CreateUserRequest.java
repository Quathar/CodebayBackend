package com.quathar.codebay.app.rest.shop.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * <h1>Create User Request</h1>
 *
 * This record encapsulates user creation details such as username, password, nickname, and email.
 *
 * @param username The username of the user. Cannot be null or blank.
 * @param password The password of the user. Cannot be null or blank. Should adhere to a specific pattern.
 * @param nickname The nickname of the user. Cannot be null or blank.
 * @param email    The email address of the user. Cannot be null or blank. Should adhere to a specific pattern.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public record CreateUserRequest(
        @NotBlank
        @Size(min = 3, max = 16)
        String username,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @NotBlank
        @Size(min = 3, max = 30)
        String nickname,
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email
) {}
