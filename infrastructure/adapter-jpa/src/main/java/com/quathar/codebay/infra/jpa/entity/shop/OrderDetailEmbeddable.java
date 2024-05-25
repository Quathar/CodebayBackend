package com.quathar.codebay.infra.jpa.entity.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <h1>Order Detail Embeddable</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.OrderDetail
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class OrderDetailEmbeddable {

    // <<-FIELDS->>
    @OneToOne(optional = false)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer units;

    @Column(nullable = false)
    private BigDecimal price;

}
