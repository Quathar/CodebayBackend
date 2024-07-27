package com.quathar.codebay.app.rest.management.model.user.response;

import com.quathar.codebay.app.rest.common.model.request.AddressSection;
import com.quathar.codebay.app.rest.common.model.request.PersonalInfoSection;

import java.math.BigDecimal;

import java.util.stream.Stream;

/**
 * <h1>Management Customer Response</h1>
 *
 * @param username
 * @param nickname
 * @param email
 * @param personalInfo
 * @param country
 * @param homeAddress
 * @param deliveryAddresses
 * @param accumulatedExpenditure
 * @param type
 * @param license
 *
 * @since 2024-XX-XX
 * @version 1.0
 * @author Q
 */
public record ManagementCustomerResponse(
        String username,
        String nickname,
        String email,
        PersonalInfoSection personalInfo,
        String country,
        AddressSection homeAddress,
        Stream<AddressSection> deliveryAddresses,
        BigDecimal accumulatedExpenditure,
        String type,
        Boolean license
) {}
