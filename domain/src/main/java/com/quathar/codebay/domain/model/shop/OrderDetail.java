package com.quathar.codebay.domain.model.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <h1>Order Detail Model</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class OrderDetail {

    // <<-FIELDS->>
    private Product    product;
    private Integer    units;
    private BigDecimal price;

}
