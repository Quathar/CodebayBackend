package com.quathar.codebay.app.rest.management.model.user.response;

import com.quathar.codebay.app.rest.common.model.request.AddressSection;
import com.quathar.codebay.app.rest.common.model.request.PersonalInfoSection;

import java.math.BigDecimal;

import java.util.stream.Stream;

/**
 * <h1>Management Customer Response</h1>
 *
 * @param username               The username of the customer.
 * @param nickname               The nickname of the customer.
 * @param email                  The email address of the customer.
 * @param personalInfo           The personal information section of the customer.
 * @param country                The country of the customer.
 * @param homeAddress            The home address of the customer.
 * @param deliveryAddresses      The delivery addresses of the customer.
 * @param accumulatedExpenditure The accumulated expenditure of the customer.
 * @param type                   The type of the customer.
 * @param license                The license status of the customer.
 *
 * @since 2023-05-06
 * @version 1.0
 * @author Q
 */
public record ManagementCustomerResponse(
        String                 username,
        String                 nickname,
        String                 email,
        PersonalInfoSection    personalInfo,
        String                 country,
        AddressSection         homeAddress,
        Stream<AddressSection> deliveryAddresses,
        BigDecimal             accumulatedExpenditure,
        String                 type,
        Boolean                license
) {}
