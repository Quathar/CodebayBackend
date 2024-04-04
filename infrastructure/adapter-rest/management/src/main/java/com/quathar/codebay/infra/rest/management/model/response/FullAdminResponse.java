package com.quathar.codebay.infra.rest.management.model.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import com.quathar.codebay.domain.model.valueobject.PersonalInfo;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Full Administrator Response</h1>
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
        LocalDateTime creationDate,
        LocalDateTime passwordExpirationDate,
        LocalDateTime endBlockDate,
        LocalDateTime lastConnection,

        // TODO: Add Audit here
        @JsonUnwrapped
        PersonalInfo  personalInfo
) {}
