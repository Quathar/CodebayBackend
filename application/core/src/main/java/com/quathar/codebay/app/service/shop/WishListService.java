package com.quathar.codebay.app.service.shop;

import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.wishlist.AddProductToWishListUseCasePort;
import com.quathar.codebay.domain.port.in.shop.wishlist.MoveProductToCartUseCasePort;
import com.quathar.codebay.domain.port.in.shop.wishlist.ReadWishListByUsernameUseCasePort;
import com.quathar.codebay.domain.port.in.shop.wishlist.RemoveProductFromWishListUseCasePort;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Wish List Service</h1>
 *
 * @see ReadWishListByUsernameUseCasePort
 * @see AddProductToWishListUseCasePort
 * @see RemoveProductFromWishListUseCasePort
 * @see MoveProductToCartUseCasePort
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class WishListService
       implements  ReadWishListByUsernameUseCasePort,
                   AddProductToWishListUseCasePort,
                   RemoveProductFromWishListUseCasePort,
                   MoveProductToCartUseCasePort {

    // <<-FIELDS->>
    @NonNull private final ReadWishListByUsernameUseCasePort    readWishListByUsernameUseCase;
    @NonNull private final AddProductToWishListUseCasePort      addProductToWishListUseCase;
    @NonNull private final RemoveProductFromWishListUseCasePort removeProductFromWishListUseCase;
    @NonNull private final MoveProductToCartUseCasePort         moveProductToCartUseCase;

    // <<-METHODS->>
    @Override
    public WishList getWishListByUsername(String username) {
        return this.readWishListByUsernameUseCase.getWishListByUsername(username);
    }

    @Override
    public WishList addToWishList(String username, String productCode) {
        return this.addProductToWishListUseCase.addToWishList(username, productCode);
    }

    @Override
    public WishList removeFromWishList(String username, String productCode) {
        return this.removeProductFromWishListUseCase.removeFromWishList(username, productCode);
    }

    @Override
    public WishList moveProductToCart(String username, String productCode) {
        return this.moveProductToCartUseCase.moveProductToCart(username, productCode);
    }

}
