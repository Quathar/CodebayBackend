package com.quathar.codebay.app.rest.common.model.request;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedRoadType;

import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Address Section</h1>
 *
 * @param roadType   The type of the road.
 * @param name       The address name.
 * @param number     The address number.
 * @param portal     The portal.
 * @param floor      The floor.
 * @param location   The location or city of the address.
 * @param region     The region or state of the address.
 * @param postalCode The postal code of the address.
 *
 * @see com.quathar.codebay.domain.valueobject.shop.Address
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record AddressSection(
        @NotBlank
        @AllowedRoadType
        String roadType,
        @NotBlank
        String name,
        @NotBlank
        String number,
        String portal,
        String floor,
        @NotBlank
        String location,
        @NotBlank
        String region,
        @NotBlank
        String postalCode
) {}
