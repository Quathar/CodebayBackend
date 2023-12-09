package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Product Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Product {

    // <<-FIELDS->>
    private UUID        id;
    private String      code;
    private String      name;
    private String      description;
    private String      brand;
    private String      model;
    private Set<Image>  productImages;
    private BigDecimal  price;
    private Integer     ratingNumber;
    private BigDecimal  rating;
    private Integer     stock;
    private Integer     unitsSold;
    private Integer     upperLimit; // At this limit, a warning will appear
    private Integer     lowerLimit; // At this limit, the product will no longer be offered
    private BigDecimal  totalEarnings; // Total money earned selling this product
    private Boolean     onSale;
    private Boolean     onOffer;
    private Boolean     isNew;
    private BigDecimal  discount;
    private String      comments;
    private Audit       audit;

}
