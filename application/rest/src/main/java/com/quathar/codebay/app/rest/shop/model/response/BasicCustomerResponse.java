package com.quathar.codebay.app.rest.shop.model.response;

import com.quathar.codebay.domain.valueobject.PersonalInfo;
import com.quathar.codebay.domain.valueobject.shop.Address;

import java.util.List;

/**
 * <h1>Basic Customer Response</h1>
 *
 * @param username     The customer username.
 * @param nickname     The nickname of the customer.
 * @param email        The email address of the customer.
 * @param personalInfo The personal information about the customer.
 * @param country      The country where the customer resides.
 * @param homeAddress  The home address representing the customer's primary address.
 * @param addresses    The list of addresses associated with the customer.
 * @param type         The type of customer (e.g., Bronze, Gold).
 * @param comments     Additional comments or notes related to the customer.
 * @param license      A boolean flag indicating whether the customer holds a valid license or subscription.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record BasicCustomerResponse(
        String        username,
        String        nickname,
        String        email,
        PersonalInfo  personalInfo,
        String        country,
        Address       homeAddress,
        // TODO: Change the domain model for a api section here and maybe a Stream?
        List<Address> addresses,
        String        type,
        String        comments,
        Boolean       license
) {}
