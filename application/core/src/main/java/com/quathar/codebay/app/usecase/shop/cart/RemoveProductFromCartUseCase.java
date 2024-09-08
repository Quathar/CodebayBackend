package com.quathar.codebay.app.usecase.shop.cart;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.RemoveProductFromCartUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Remove product from shopping cart Use Case Implementation</h1>
 *
 * @see RemoveProductFromCartUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class RemoveProductFromCartUseCase implements RemoveProductFromCartUseCasePort {

    // <<-FIELDS->>
    /**
     * The shopping cart repository port.
     */
    @NonNull
    private final ShoppingCartRepositoryPort cartRepositoryPort;
    /**
     * The product repository port.
     */
    @NonNull
    private final ProductRepositoryPort productRepositoryPort;

    // <<-METHOD->>
    @Override
    public ShoppingCart removeFromCart(String username, String productCode) {
        Product product = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(() -> new ModelNotFoundException("Product with ID " + productCode + " NOT FOUND"));
        ShoppingCart cart = this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException("Shopping Cart with customer username " + username + " NOT FOUND"));

        cart.removeProduct(product);

        return this.cartRepositoryPort.save(cart);
    }

}
