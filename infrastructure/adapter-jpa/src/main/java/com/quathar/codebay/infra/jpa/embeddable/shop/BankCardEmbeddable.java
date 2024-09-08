package com.quathar.codebay.infra.jpa.embeddable.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <h1>Bank Card Embeddable</h1>
 *
 * @see com.quathar.codebay.domain.valueobject.shop.BankCard
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class BankCardEmbeddable {

    // <<-FIELDS->>
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private String ccv;

}
