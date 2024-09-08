package com.quathar.codebay.domain.port.in.shop.wishlist;

import com.quathar.codebay.domain.model.shop.WishList;

/**
 * <h1>Move product to shopping cart Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface MoveProductToCartUseCasePort {

    /**
     * Moves the specified product to the shopping cart for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product to move to the shopping cart
     * @return The updated wish list after moving the product to the shopping cart
     */
    WishList moveProductToCart(String username, String productCode);

}
