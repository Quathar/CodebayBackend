package com.quathar.codebay.app.rest.management.model.user.response;

import com.quathar.codebay.app.rest.common.model.request.AddressSection;
import com.quathar.codebay.app.rest.common.model.request.PersonalInfoSection;
import com.quathar.codebay.domain.valueobject.shop.BankCard;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Full Customer Response</h1>
 *
 * @param id                     Unique identifier for the customer.
 * @param username               The username of the customer.
 * @param nickname               The nickname of the customer.
 * @param email                  The email address of the customer.
 * @param personalInfo           The personal information section of the customer.
 * @param country                The country of the customer.
 * @param homeAddress            The home address of the customer.
 * @param deliveryAddresses      The stream of delivery addresses for the customer.
 * @param bankCards              The stream of bank cards associated with the customer.
 * @param accumulatedExpenditure The total amount of money spent by the customer.
 * @param type                   The type of customer.
 * @param comments               Any comments related to the customer.
 * @param license                Indicates if the customer has accepted the license agreement.
 *
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record FullCustomerResponse(
        UUID                   id,
        String                 username,
        String                 nickname,
        String                 email,
        PersonalInfoSection    personalInfo,
        String                 country,
        AddressSection         homeAddress,
        Stream<AddressSection> deliveryAddresses,
        Stream<BankCard>       bankCards,
        BigDecimal             accumulatedExpenditure,
        String                 type,
        String                 comments,
        Boolean                license
) {}
