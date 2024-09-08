package com.quathar.codebay.infra.jpa.entity.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Cart Detail Embeddable</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.CartDetail
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class CartDetailEmbeddable {

    // <<-FIELDS->>
    @ManyToOne(optional = false)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer units;

}
