package com.quathar.codebay.app.rest.common.model.response;

import java.math.BigDecimal;

/**
 * <h1>Order Detail Response</h1>
 *
 * @param productCode The code of the product.
 * @param units       The number of units.
 * @param price       The price of the order.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record OrderDetailResponse(
        String     productCode,
        Integer    units,
        BigDecimal price
) {}
