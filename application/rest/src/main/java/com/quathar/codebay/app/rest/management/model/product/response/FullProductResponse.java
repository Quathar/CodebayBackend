package com.quathar.codebay.app.rest.management.model.product.response;

import com.quathar.codebay.app.rest.management.model.response.AuditResponse;
import com.quathar.codebay.domain.valueobject.shop.Image;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Full Product Response</h1>
 *
 * @param id             The unique identifier of the product.
 * @param code           The product code.
 * @param name           The name of the product.
 * @param description    The description of the product.
 * @param brand          The brand of the product.
 * @param model          The model of the product.
 * @param productImages  The stream of product images.
 * @param price          The price of the product.
 * @param ratingNumber   The number of ratings the product has received.
 * @param rating         The average rating of the product.
 * @param stock          The stock count of the product.
 * @param unitsSold      The number of units sold.
 * @param upperLimit     The upper stock limit.
 * @param lowerLimit     The lower stock limit.
 * @param totalEarnings  The total earnings from the product.
 * @param onSale         Indicates if the product is on sale.
 * @param onOffer        Indicates if the product is on offer.
 * @param isNew          Indicates if the product is new.
 * @param discount       The discount applied to the product.
 * @param comments       The comments about the product.
 * @param audit          The audit information of the product.
 *
 * @since 2023-05-06
 * @version 1.0
 * @author Q
 */
public record FullProductResponse(
        UUID          id,
        String        code,
        String        name,
        String        description,
        String        brand,
        String        model,
        Stream<Image> productImages,
        BigDecimal    price,
        Integer       ratingNumber,
        BigDecimal    rating,
        Integer       stock,
        Integer       unitsSold,
        Integer       upperLimit,
        Integer       lowerLimit,
        BigDecimal    totalEarnings,
        Boolean       onSale,
        Boolean       onOffer,
        Boolean       isNew,
        BigDecimal    discount,
        String        comments,
        AuditResponse audit
) {}
