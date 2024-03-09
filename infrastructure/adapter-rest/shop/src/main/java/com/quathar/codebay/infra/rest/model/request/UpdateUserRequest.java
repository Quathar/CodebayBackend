package com.quathar.codebay.infra.rest.model.request;

import com.quathar.codebay.domain.model.enumerator.UserStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * <h1>Update User Request Body</h1>
 * <br>
 * <p>
 *     This record encapsulates user update details such as username, password, nickname, and email.
 * </p>
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
        @NotBlank
        String username,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @NotBlank
        String nickname,
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email,
        @NotNull
        UserStatus status
) {}
