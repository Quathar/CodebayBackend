package com.quathar.codebay.domain.valueobject.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Address Value Object</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class Address {

    // <<-FIELDS->>
    private String roadType; // [Hwy:Highway, St:Street, Av:Avenue, Sq:Square, Bv:Boulevard]
    private String name;
    private String number;
    private String portal;
    private String floor;
    private String location;
    private String region;
    private String postalCode;

}
