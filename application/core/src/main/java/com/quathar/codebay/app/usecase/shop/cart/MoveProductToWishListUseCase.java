package com.quathar.codebay.app.usecase.shop.cart;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.cart.MoveProductToWishListUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Move product to shopping cart Use Case Implementation</h1>
 *
 * @see MoveProductToWishListUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class MoveProductToWishListUseCase implements MoveProductToWishListUseCasePort {

    // <<-FIELDS->>
    /**
     * The shopping cart repository port.
     */
    @NonNull
    private final ShoppingCartRepositoryPort cartRepositoryPort;
    /**
     * The wish list repository port.
     */
    @NonNull
    private final WishListRepositoryPort wishlistRepositoryPort;
    /**
     * The product repository port.
     */
    @NonNull
    private final ProductRepositoryPort productRepositoryPort;

    // <<-METHOD->>
    @Override
    public ShoppingCart moveProductToWishList(String username, String productCode) {
        ShoppingCart cart = this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
        WishList wishList = this.wishlistRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
        Product productToMove = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(ModelNotFoundException::new);

        // 1. Update wish list
        if (!wishList.hasProduct(productToMove)) {
            wishList.addProduct(productToMove);
            this.wishlistRepositoryPort.save(wishList);
        }

        // 2. Update shopping cart
        cart.removeProduct(productToMove);
        return this.cartRepositoryPort.save(cart);
    }

}
