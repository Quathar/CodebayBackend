package com.quathar.codebay.domain.port.out.shop;

import com.quathar.codebay.domain.model.shop.WishList;

/**
 * <h1>Wish List Repository Port</h1>
 *
 * @see WishList
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface WishListRepositoryPort {

    /**
     * Retrieves the wish list associated with the specified customer.
     *
     * @param username The username of the customer
     * @return An optional containing the WishList associated with the username, or empty if not found
     */
    java.util.Optional<WishList> findByUsername(String username);

    /**
     * Saves a WishList domain model.
     *
     * @param model The WishList domain model to be saved
     * @return The saved WishList domain model
     */
    WishList save(WishList model);

}
