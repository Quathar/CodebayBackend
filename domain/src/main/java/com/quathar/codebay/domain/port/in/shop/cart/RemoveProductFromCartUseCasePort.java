package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Remove product from shopping cart Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface RemoveProductFromCartUseCasePort {

    /**
     * Removes the specified product from the shopping cart for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product
     * @return The updated shopping cart after removing the product
     */
    ShoppingCart removeFromCart(String username, String productCode);

}
