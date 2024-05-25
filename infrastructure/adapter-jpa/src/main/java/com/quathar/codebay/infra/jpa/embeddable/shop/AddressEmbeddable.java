package com.quathar.codebay.infra.jpa.embeddable.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Address Embeddable</h1>
 *
 * @see com.quathar.codebay.domain.valueobject.shop.Address
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class AddressEmbeddable {

    // <<-FIELDS->>
    @Column(nullable = false)
    private String roadType;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    private String portal;

    private String floor;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String postalCode;

}
