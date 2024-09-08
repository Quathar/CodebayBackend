package com.quathar.codebay.domain.port.in.shop.wishlist;

import com.quathar.codebay.domain.model.shop.WishList;

/**
 * <h1>Read wish list by username Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ReadWishListByUsernameUseCasePort {

    /**
     * Retrieves the wish list for the specified customer.
     *
     * @param username The username of the customer
     * @return The wish list associated with the username
     */
    WishList getWishListByUsername(String username);

}
