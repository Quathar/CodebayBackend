package com.quathar.codebay.infra.rest.model.response;

import java.util.UUID;

/**
 * <h1>Basic User Response</h1>
 * <br>
 * <p>
 *     Represents a basic user response containing essential user details.
 * </p>
 *
 * @param id       The unique identifier of the user.
 * @param username The username of the user.
 * @param nickname The user's nickname or display name.
 * @param email    The user's email address.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public record BasicUserResponse(
        UUID   id,
        String username,
        String nickname,
        String email
) {}
