package com.quathar.codebay.app.usecase.shop.wishlist;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.wishlist.RemoveProductFromWishListUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Remove product from wish list Use Case Implementation</h1>
 *
 * @see RemoveProductFromWishListUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class RemoveProductFromWishListUseCase implements RemoveProductFromWishListUseCasePort {

    // <<-FIELDS->>
    /**
     * The shopping cart repository port.
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
    public WishList removeFromWishList(String username, String productCode) {
        Product product = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(() -> new ModelNotFoundException("Product with ID " + productCode + " NOT FOUND"));
        WishList wishList = this.wishlistRepositoryPort
                .findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException("Wish List with customer username " + username + " NOT FOUND"));

        wishList.removeProduct(product);

        return this.wishlistRepositoryPort.save(wishList);
    }

}
