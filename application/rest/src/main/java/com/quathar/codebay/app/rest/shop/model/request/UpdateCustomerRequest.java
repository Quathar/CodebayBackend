package com.quathar.codebay.app.rest.shop.model.request;

import com.quathar.codebay.app.rest.common.model.request.AddressSection;
import com.quathar.codebay.app.rest.common.model.request.PersonalInfoSection;

/**
 * <h1>Update Customer Request</h1>
 *
 * @param personalInfo The updated personal information section of the customer.
 * @param country      The updated country of the customer.
 * @param homeAddress  The updated home address of the customer.
 *
 * @see PersonalInfoSection
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record UpdateCustomerRequest(
        PersonalInfoSection personalInfo,
        String              country,
        AddressSection      homeAddress
) {}
