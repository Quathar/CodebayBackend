package com.quathar.codebay.app.rest.shop.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Buy Product Request</h1>
 *
 * @param productCode The unique code of the product to be purchased.
 * @param units       The number of units to be purchased.
 *
 * @since 2024-07-24
 * @version 1.0
 * @author Q
 */
public record BuyProductRequest(
        @NotBlank
        String productCode,
        @Min(value = 1)
        Integer units
) {}
