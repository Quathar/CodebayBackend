package com.quathar.codebay.infra.rest.model.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import com.quathar.codebay.domain.model.valueobject.PersonalInfo;

import java.time.LocalDateTime;

/**
 * <h1>Management Administrator Response</h1>
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public record ManagementAdminResponse(
        String        username,
        String        nickname,
        String        email,
        String        status,
        String        role,
        Integer       successfulAuth,
        Integer       failedAuth,
        LocalDateTime passwordExpirationDate,
        LocalDateTime endBlockDate,
        @JsonUnwrapped
        PersonalInfo  personalInfo
) {}
