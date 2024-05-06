package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.model.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Shopping Cart Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class ShoppingCart {

    // <<-FIELDS->>
    private UUID               id;
    private Customer           customer;
    private Stream<CartDetail> details;
    private BigDecimal         price;

}
