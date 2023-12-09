package com.quathar.codebay.domain.model.common;

import com.quathar.codebay.domain.model.type.RoadType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Address</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Address {

    // <<-FIELDS->>
    private RoadType roadType; // [Hwy:Highway, St:Street, Av:Avenue, Sq:Square, Bv:Boulevard]
    private String   name;
    private String   number;
    private String   portal;
    private String   floor;
    private String   location;
    private String   region;
    private String   postalCode;

}
