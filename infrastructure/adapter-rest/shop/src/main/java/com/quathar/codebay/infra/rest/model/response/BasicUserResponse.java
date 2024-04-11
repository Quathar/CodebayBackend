package com.quathar.codebay.infra.rest.model.response;

/**
 * <h1>Basic User Response</h1>
 * Represents a basic user response containing essential user details.
 *
 * @param username The username of the user.
 * @param nickname The user's nickname or display name.
 * @param email    The user's email address.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public record BasicUserResponse(
        String username,
        String nickname,
        String email
) {}
