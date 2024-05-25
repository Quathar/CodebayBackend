package com.quathar.codebay.app.service.shop;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.AddProductToCartUseCasePort;
import com.quathar.codebay.domain.port.in.shop.cart.BuyCartProductsUseCasePort;
import com.quathar.codebay.domain.port.in.shop.cart.MoveProductToWishListUseCasePort;
import com.quathar.codebay.domain.port.in.shop.cart.ReadCartByUsernameUseCasePort;
import com.quathar.codebay.domain.port.in.shop.cart.RemoveProductFromCartUseCasePort;
import com.quathar.codebay.domain.port.in.shop.cart.UpdateProductInCartUseCasePort;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Shopping Cart Service</h1>
 *
 * @see ReadCartByUsernameUseCasePort
 * @see AddProductToCartUseCasePort
 * @see UpdateProductInCartUseCasePort
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
                   UpdateProductInCartUseCasePort,
                   RemoveProductFromCartUseCasePort,
                   MoveProductToWishListUseCasePort,
                   BuyCartProductsUseCasePort {

    // <<-FIELDS->>
    @NonNull private final ReadCartByUsernameUseCasePort    readCartByUsernameUseCase;
    @NonNull private final AddProductToCartUseCasePort      addProductToCartUseCase;
    @NonNull private final UpdateProductInCartUseCasePort   updateProductInCartUseCase;
    @NonNull private final RemoveProductFromCartUseCasePort removeProductFromCartUseCase;
    @NonNull private final MoveProductToWishListUseCasePort moveProductToWishListUseCase;
    @NonNull private final BuyCartProductsUseCasePort       buyCartProductsUseCase;

    // <<-METHODS->>
    @Override
    public ShoppingCart getCartByUsername(String username) {
        return this.readCartByUsernameUseCase.getCartByUsername(username);
    }

    @Override
    public ShoppingCart addToCart(String username, String productId, int units) {
        return this.addProductToCartUseCase.addToCart(username, productId, units);
    }

    @Override
    public ShoppingCart updateInCart(String username, String productCode, int units) {
        return this.updateProductInCartUseCase.updateInCart(username, productCode, units);
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
