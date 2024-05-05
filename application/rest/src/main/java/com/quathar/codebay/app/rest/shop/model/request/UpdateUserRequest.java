package com.quathar.codebay.app.rest.shop.model.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * <h1>Update User Request</h1>
 *
 * @param username The username of the user. Cannot be blank.
 * @param password The password of the user. Cannot be blank. Should adhere to a specific pattern.
 * @param nickname The nickname of the user. Cannot be blank.
 * @param email    The email address of the user. Cannot be blank. Should adhere to a specific pattern.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public record UpdateUserRequest(
        @Size(min = 3, max = 16)
        String username,
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @Size(min = 3, max = 30)
        String nickname,
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email
) {}
