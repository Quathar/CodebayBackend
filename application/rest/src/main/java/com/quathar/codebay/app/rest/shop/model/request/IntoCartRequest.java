package com.quathar.codebay.app.rest.shop.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Into Cart Request</h1>
 *
 * @param productCode The unique code of the product to be purchased.
 * @param units       The number of units to be purchased.
 *
 * @since 2024-07-24
 * @version 1.0
 * @author Q
 */
public record IntoCartRequest(
        @NotBlank
        String productCode,
        @Min(value = 1)
        @Max(value = 5)
        Integer units
) {}
