package com.quathar.codebay.app.rest.management.model.user.response;

import com.quathar.codebay.app.rest.management.model.response.AuditResponse;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Full User Information Response</h1>
 *
 * Represents a 'full user information' response containing ALL user details.
 *
 * @param id                     The unique identifier.
 * @param username               The username of the user.
 * @param nickname               The user's nickname or display name.
 * @param email                  The user's email address.
 * @param status                 The status of the user.
 * @param role                   The role of the user.
 * @param successfulAuth         The number of successful authentications.
 * @param failedAuth             The number of failed authentication attempts.
 * @param passwordExpirationDate The date when the password expires.
 * @param endBlockDate           The date when the user's account is blocked.
 * @param lastConnection         The last connection date of the user.
 * @param audit                  The audit information.
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
        LocalDateTime passwordExpirationDate,
        LocalDateTime endBlockDate,
        LocalDateTime lastConnection,
        AuditResponse audit
) {}
