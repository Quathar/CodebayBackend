package com.quathar.codebay.app.rest.shop.model.response;

import com.quathar.codebay.app.rest.common.model.response.CartDetailResponse;

import java.util.stream.Stream;

/**
 * <h1>Basic Shopping Cart Response</h1>
 *
 * @param username The customer username.
 * @param details  The details of the items in the cart.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record BasicCartResponse(
        String                     username,
        Stream<CartDetailResponse> details
) {}
