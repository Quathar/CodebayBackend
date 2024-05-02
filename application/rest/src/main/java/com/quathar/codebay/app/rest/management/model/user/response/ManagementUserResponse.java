package com.quathar.codebay.app.rest.management.model.user.response;

import java.time.LocalDateTime;

/**
 * <h1>Management User Response</h1>
 *
 * Represents a 'management user information' response containing management user details.
 *
 * @param username               The username of the user.
 * @param nickname               The user's nickname or display name.
 * @param email                  The user's email address.
 * @param status                 The status of the user.
 * @param role                   The role of the user.
 * @param successfulAuth         The number of successful authentications.
 * @param failedAuth             The number of failed authentication attempts.
 * @param passwordExpirationDate The date when the password expires.
 * @param endBlockDate           The date when the user's account is blocked.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public record ManagementUserResponse(
        String        username,
        String        nickname,
        String        email,
        String        status,
        String        role,
        Integer       successfulAuth,
        Integer       failedAuth,
        LocalDateTime passwordExpirationDate,
        LocalDateTime endBlockDate
) {}
