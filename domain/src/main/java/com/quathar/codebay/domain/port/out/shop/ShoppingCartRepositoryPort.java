package com.quathar.codebay.domain.port.out.shop;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Shopping Cart Repository Port</h1>
 *
 * @see ShoppingCart
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ShoppingCartRepositoryPort {

    /**
     * Retrieves the shopping cart associated with the specified customer.
     *
     * @param username The username of the customer
     * @return An optional containing the ShoppingCart associated with the username, or empty if not found
     */
    java.util.Optional<ShoppingCart> findByUsername(String username);

    /**
     * Saves a ShoppingCart domain model.
     *
     * @param model The ShoppingCart domain model to be saved
     * @return The saved ShoppingCart domain model
     */
    ShoppingCart save(ShoppingCart model);

}
