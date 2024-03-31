package com.quathar.codebay.infra.rest.model.response;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Full User Information Response</h1>
 *
 * Represents a 'full user information' response containing ALL user details.
 *
 * @param id                     The user identifier
 * @param username               The username of the user.
 * @param nickname               The user's nickname or display name.
 * @param email                  The user's email address.
 * @param status                 The status of the user.
 * @param role                   The role of the user.
 * @param successfulAuth         The number of successful authentications.
 * @param failedAuth             The number of failed authentication attempts.
 * @param creationDate           The date when the user was created
 * @param passwordExpirationDate The date when the password expires.
 * @param endBlockDate           The date when the user's account is blocked.
 * @param lastConnection         The last connection date of the user
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
public record FullUserResponse(
        UUID          id,
        String        username,
        String        nickname,
        String        email,
        String        status,
        String        role,
        Integer       successfulAuth,
        Integer       failedAuth,
        LocalDateTime creationDate,
        LocalDateTime passwordExpirationDate,
        LocalDateTime endBlockDate,
        LocalDateTime lastConnection

        // TODO: Add Audit here
) {}
