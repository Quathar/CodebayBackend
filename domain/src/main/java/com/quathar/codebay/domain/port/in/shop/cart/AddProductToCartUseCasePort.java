package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Add product to shopping cart Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface AddProductToCartUseCasePort {

    /**
     * Adds the specified number of units of a product to the shopping cart for the given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product to add to the cart
     * @param units       The number of units of the product to add
     * @return The updated shopping cart after adding the product
     */
    ShoppingCart addToCart(String username, String productCode, int units);

}
