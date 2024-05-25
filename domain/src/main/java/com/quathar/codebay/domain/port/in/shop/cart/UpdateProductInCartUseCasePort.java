package com.quathar.codebay.domain.port.in.shop.cart;

import com.quathar.codebay.domain.model.shop.ShoppingCart;

/**
 * <h1>Update product in shopping cart Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface UpdateProductInCartUseCasePort {

    /**
     * Updates the quantity of a product in the shopping cart for a given customer.
     *
     * @param username    The username of the customer
     * @param productCode The code of the product to update in the cart
     * @param units       The number of units of the product to update
     * @return The updated shopping cart after updating the product
     */
    ShoppingCart updateInCart(String username, String productCode, int units);

}
