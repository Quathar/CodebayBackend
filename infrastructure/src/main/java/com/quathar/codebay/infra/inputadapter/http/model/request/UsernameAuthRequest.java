package com.quathar.codebay.infra.inputadapter.http.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 *
 * @param username
 * @param password
 */
public record UsernameAuthRequest(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String password
) {}
