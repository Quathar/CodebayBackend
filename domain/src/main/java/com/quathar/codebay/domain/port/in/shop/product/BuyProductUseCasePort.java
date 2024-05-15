package com.quathar.codebay.domain.port.in.shop.product;

import com.quathar.codebay.domain.model.shop.Order;

/**
 * <h1>Buy product Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface BuyProductUseCasePort {

    /**
     * Buys the specified number of units of a product identified by its code for the given customer.
     *
     * @param username The username of the customer
     * @param code     The code of the product to buy
     * @param units    The number of units to buy
     * @return The order representing the purchase
     */
    Order buyProduct(String username, String code, int units);

}
