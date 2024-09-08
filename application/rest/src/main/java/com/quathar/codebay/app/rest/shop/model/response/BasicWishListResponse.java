package com.quathar.codebay.app.rest.shop.model.response;

import java.util.stream.Stream;

/**
 * <h1>Basic Wish List Response</h1>
 *
 * @param username     The customer username.
 * @param productCodes The product codes of the items in the cart.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record BasicWishListResponse(
        String         username,
        Stream<String> productCodes
) {}
