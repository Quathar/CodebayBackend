package com.quathar.codebay.app.rest.management.model.product.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * <h1>Management Product Parameters</h1>
 *
 * @param page         The page number of the results to retrieve. Must be zero or positive.
 * @param size         The number of results per page. Must be between 1 and 100 inclusive.
 * @param code         The product code to filter the search results. Can be null if not used.
 * @param onSale       Boolean flag indicating if the product is on sale. Can be null if not used.
 * @param onOffer      Boolean flag indicating if the product is currently on offer. Can be null if not used.
 * @param isNew        Boolean flag indicating if the product is new. Can be null if not used.
 * @param minPrice     The minimum price of the products to be included in the search results. Must be zero or positive.
 * @param maxPrice     The maximum price of the products to be included in the search results. Must be zero or positive.
 * @param minRating    The minimum rating of the products to be included in the search results. Must be between 0 and 5 inclusive.
 * @param maxRating    The maximum rating of the products to be included in the search results. Must be between 0 and 5 inclusive.
 * @param minStock     The minimum stock quantity of the products to be included in the search results. Must be zero or positive.
 * @param maxStock     The maximum stock quantity of the products to be included in the search results. Must be zero or positive.
 * @param minUnitsSold The minimum units sold of the products to be included in the search results. Must be zero or positive.
 * @param maxUnitsSold The maximum units sold of the products to be included in the search results. Must be zero or positive.
 * @param minDiscount  The minimum discount percentage of the products to be included in the search results. Must be between 0 and 1 inclusive.
 * @param maxDiscount  The maximum discount percentage of the products to be included in the search results. Must be between 0 and 1 inclusive.
 *
 * @see com.quathar.codebay.domain.model.shop.ProductFilters
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
public record ManagementProductParams(
        @NotNull
        @Min(value = 0)
        Integer page,
        @NotNull
        @Min(value = 1)
        @Max(value = 100)
        Integer size,
        String code,
        Boolean onSale,
        Boolean onOffer,
        Boolean isNew,
        @Min(value = 0)
        BigDecimal minPrice,
        @Min(value = 0)
        BigDecimal maxPrice,
        @Min(value = 0)
        @Max(value = 5)
        BigDecimal minRating,
        @Min(value = 0)
        @Max(value = 5)
        BigDecimal maxRating,
        @Min(value = 0)
        Integer minStock,
        @Min(value = 0)
        Integer maxStock,
        @Min(value = 0)
        Integer minUnitsSold,
        @Min(value = 0)
        Integer maxUnitsSold,
        @Min(value = 0)
        @Max(value = 1)
        BigDecimal minDiscount,
        @Min(value = 0)
        @Max(value = 1)
        BigDecimal maxDiscount
) {}
