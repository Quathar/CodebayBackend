package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.Order;

/**
 * <h1>Buy shopping cart products Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface BuyCartProductsUseCasePort {

    /**
     * Buys the products in the shopping cart for the specified customer.
     *
     * @param username The username of the customer
     * @return The order representing the purchase
     */
    Order buyCartProducts(String username);

}
