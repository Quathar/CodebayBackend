package com.quathar.codebay.app.service.shop;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.*;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Shopping Cart Service</h1>
 *
 * @see ReadCartByUsernameUseCasePort
 * @see AddProductToCartUseCasePort
 * @see RemoveProductFromCartUseCasePort
 * @see MoveProductToWishListUseCasePort
 * @see BuyCartProductsUseCasePort
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class ShoppingCartService
       implements  ReadCartByUsernameUseCasePort,
                   AddProductToCartUseCasePort,
                   RemoveProductFromCartUseCasePort,
                   MoveProductToWishListUseCasePort,
                   BuyCartProductsUseCasePort {

    // <<-FIELDS->>
    @NonNull private final ReadCartByUsernameUseCasePort    readCartByUsernameUseCasePort;
    @NonNull private final AddProductToCartUseCasePort      addProductToCartUseCase;
    @NonNull private final RemoveProductFromCartUseCasePort removeProductFromCartUseCase;
    @NonNull private final MoveProductToWishListUseCasePort moveProductToWishListUseCase;
    @NonNull private final BuyCartProductsUseCasePort       buyCartProductsUseCase;

    // <<-METHODS->>
    @Override
    public ShoppingCart getCartByUsername(String username) {
        return this.readCartByUsernameUseCasePort.getCartByUsername(username);
    }

    @Override
    public ShoppingCart addToCart(String username, String productId, int units) {
        return this.addProductToCartUseCase.addToCart(username, productId, units);
    }

    @Override
    public ShoppingCart removeFromCart(String username, String productCode) {
        return this.removeProductFromCartUseCase.removeFromCart(username, productCode);
    }

    @Override
    public ShoppingCart moveProductToWishList(String username, String productCode) {
        return this.moveProductToWishListUseCase.moveProductToWishList(username, productCode);
    }

    @Override
    public Order buyCartProducts(String username) {
        return this.buyCartProductsUseCase.buyCartProducts(username);
    }

}
