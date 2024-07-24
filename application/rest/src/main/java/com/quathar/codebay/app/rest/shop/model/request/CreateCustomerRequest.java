package com.quathar.codebay.app.rest.shop.model.request;

import com.quathar.codebay.app.rest.common.model.request.PersonalInfoSection;
import com.quathar.codebay.domain.valueobject.shop.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Create Customer Request</h1>
 *
 * @param username
 * @param personalInfo
 * @param country
 * @param homeAddress
 * @param license
 *
 * @see PersonalInfoSection
 * @since 2024-0X-XX
 * @version 1.0
 * @author Q
 */
public record CreateCustomerRequest(
        @NotBlank
        String username,
        PersonalInfoSection personalInfo,
        String country,
        // TODO: We should change this Address object for some DTO that can contain validations
        Address homeAddress,
        @NotNull
        Boolean license
) {}
