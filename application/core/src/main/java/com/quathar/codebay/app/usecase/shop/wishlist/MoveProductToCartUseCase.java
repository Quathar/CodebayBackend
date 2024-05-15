package com.quathar.codebay.app.usecase.shop.wishlist;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.wishlist.MoveProductToCartUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Move product to shopping cart Use Case Implementation</h1>
 *
 * @see MoveProductToCartUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class MoveProductToCartUseCase implements MoveProductToCartUseCasePort {

    // <<-CONSTANT->>
    /**
     * Default number of product units to move to the shopping cart.
     */
    private static final int DEFAULT_UNITS = 1;

    // <<-FIELDS->>
    /**
     * The wish list repository port.
     */
    @NonNull
    private final WishListRepositoryPort wishlistRepositoryPort;
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
    public WishList moveProductToCart(String username, String productCode) {
        WishList wishList = this.wishlistRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
        ShoppingCart cart = this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
        Product productToMove = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(ModelNotFoundException::new);

        // Update shopping cart
        if (!cart.hasProduct(productToMove)) {
            cart.addProduct(productToMove, DEFAULT_UNITS);
            this.cartRepositoryPort.save(cart);
        }

        // Update wish list
        wishList.removeProduct(productToMove);
        return this.wishlistRepositoryPort.save(wishList);
    }

}
