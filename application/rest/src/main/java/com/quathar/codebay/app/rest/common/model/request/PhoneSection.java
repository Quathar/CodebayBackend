package com.quathar.codebay.app.rest.common.model.request;

import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Phone Section</h1>
 *
 * @param countryCode the country code of the phone number
 * @param number      the phone number
 *
 * @see com.quathar.codebay.domain.valueobject.PersonalInfo
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record PhoneSection(
        @NotBlank
        String countryCode,
        @NotBlank
        String number
) {}
