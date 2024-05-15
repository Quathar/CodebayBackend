package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Move product to wish list Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface MoveProductToWishListUseCasePort {

    /**
     * Moves the specified product to the wish list for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product to move to the wish list
     * @return The updated shopping cart after moving the product to the wish list
     */
    ShoppingCart moveProductToWishList(String username, String productCode);

}
