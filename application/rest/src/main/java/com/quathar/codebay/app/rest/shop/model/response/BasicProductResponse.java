package com.quathar.codebay.app.rest.shop.model.response;

import com.quathar.codebay.domain.valueobject.shop.Image;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * <h1>Basic Product Response</h1>
 *
 * @param code          The product code.
 * @param name          The name of the product.
 * @param brand         The brand of the product.
 * @param model         The model of the product.
 * @param price         The price of the product.
 * @param ratingNumber  The number of ratings for the product.
 * @param rating        The rating of the product.
 * @param stock         The stock quantity of the product.
 * @param onOffer       Indicates if the product is on offer.
 * @param isNew         Indicates if the product is new.
 * @param discount      The discount decimal applied to the product.
 * @param description   The description of the product.
 * @param comments      Comments or reviews about the product.
 * @param productImages Images of the product.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record BasicProductResponse(
        String        code,
        String        name,
        String        brand,
        String        model,
        BigDecimal    price,
        Integer       ratingNumber,
        BigDecimal    rating,
        Integer       stock,
        Boolean       onOffer,
        Boolean       isNew,
        BigDecimal    discount,
        String        description,
        String        comments,
        Stream<Image> productImages
) {}
