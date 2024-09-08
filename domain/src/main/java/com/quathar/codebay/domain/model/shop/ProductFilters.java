package com.quathar.codebay.domain.model.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <h1>Product Filters Model</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class ProductFilters {

    // <<-FIELDS->>
    private Integer    pageIndex;
    private Integer    pageSize;
    private String     code;
    private Boolean    onSale;
    private Boolean    onOffer;
    private Boolean    isNew;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal minRating;
    private BigDecimal maxRating;
    private Integer    minStock;
    private Integer    maxStock;
    private Integer    minUnitsSold;
    private Integer    maxUnitsSold;
    private BigDecimal minDiscount;
    private BigDecimal maxDiscount;

}
