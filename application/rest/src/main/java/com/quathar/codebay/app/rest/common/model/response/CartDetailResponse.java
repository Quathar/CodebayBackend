package com.quathar.codebay.app.rest.common.model.response;

/**
 * <h1>Cart Detail Response</h1>
 *
 * @param productCode The code of the product.
 * @param units       The number of units.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record CartDetailResponse(
        String  productCode,
        Integer units
) {}
