package com.quathar.codebay.app.rest.shop.model.response;

/**
 * <h1>Basic User Response</h1>
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
