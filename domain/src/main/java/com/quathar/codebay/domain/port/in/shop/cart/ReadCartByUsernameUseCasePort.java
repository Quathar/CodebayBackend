package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Read shopping cart by username Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ReadCartByUsernameUseCasePort {

    /**
     * Retrieves the shopping cart for the specified customer.
     *
     * @param username The username of the customer
     * @return The shopping cart associated with the username
     */
    ShoppingCart getCartByUsername(String username);

}
