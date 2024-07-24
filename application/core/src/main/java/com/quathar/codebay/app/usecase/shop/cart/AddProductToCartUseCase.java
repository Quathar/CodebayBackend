package com.quathar.codebay.app.usecase.shop.cart;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.CartDetail;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.AddProductToCartUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Add product to shopping cart Use Case Implementation</h1>
 *
 * @see AddProductToCartUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class AddProductToCartUseCase implements AddProductToCartUseCasePort {

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
    /**
     * Checks if the specified product is already present in the given shopping cart.
     *
     * @param cart           The shopping cart to be checked.
     * @param productToCheck The product to look for in the shopping cart.
     * @return {@code true} if the product is already in the cart; {@code false} otherwise.
     */
    private boolean isAlreadyInTheCart(ShoppingCart cart, Product productToCheck) {
        return cart.cloneDetails()
                .map(CartDetail::getProduct)
                .anyMatch(product -> product.equals(productToCheck));
    }

    @Override
    public ShoppingCart addToCart(String username, String productCode, int units) {
        Product product = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(() -> new ModelNotFoundException("Product with code " + productCode + " NOT FOUND"));
        ShoppingCart cart = this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException("Shopping Cart with customer username " + username + " NOT FOUND"));

        if ( this.isAlreadyInTheCart(cart, product) )
            cart.updateProductUnits(product, units);
        else cart.addProduct(product, units);

        return this.cartRepositoryPort.save(cart);
    }

}
