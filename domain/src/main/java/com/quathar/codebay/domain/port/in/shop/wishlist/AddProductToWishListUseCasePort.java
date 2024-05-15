package com.quathar.codebay.domain.port.in.shop.wishlist;

import com.quathar.codebay.domain.model.shop.WishList;

/**
 * <h1>Add product to wish list Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface AddProductToWishListUseCasePort {

    /**
     * Adds the specified number of units of a product to the wish list for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product to add to the wish list
     * @return The updated wish list after adding the product
     */
    WishList addToWishList(String username, String productCode);

}
