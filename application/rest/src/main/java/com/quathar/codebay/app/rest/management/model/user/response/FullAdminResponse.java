package com.quathar.codebay.app.rest.management.model.user.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import com.quathar.codebay.app.rest.management.model.response.AuditResponse;
import com.quathar.codebay.domain.valueobject.PersonalInfo;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Full Administrator Response</h1>
 *
 * @param id                     The unique identifier.
 * @param username               The username of the administrator.
 * @param nickname               The nickname of the administrator.
 * @param email                  The email address of the administrator.
 * @param status                 The status of the admin.
 * @param role                   The role of the admin.
 * @param successfulAuth         The number of successful authentications.
 * @param failedAuth             The number of failed authentication attempts.
 * @param passwordExpirationDate The date when the password expires.
 * @param endBlockDate           The date when the user's account is blocked.
 * @param lastConnection         The last connection date of the user.
 * @param audit                  The audit information.
 * @param personalInfo           The personal information.
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public record FullAdminResponse(
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
        AuditResponse audit,
        @JsonUnwrapped
        PersonalInfo  personalInfo
) {}
