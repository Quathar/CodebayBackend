package com.quathar.codebay.domain.port.in.shop.wishlist;

import com.quathar.codebay.domain.model.shop.WishList;

/**
 * <h1>Remove product from wish list Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface RemoveProductFromWishListUseCasePort {

    /**
     * Removes the specified product from the wish list for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product
     * @return The updated wish list after removing the product
     */
    WishList removeFromWishList(String username, String productCode);

}
