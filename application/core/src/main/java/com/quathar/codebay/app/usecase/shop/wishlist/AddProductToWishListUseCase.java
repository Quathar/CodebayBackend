package com.quathar.codebay.app.usecase.shop.wishlist;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.wishlist.AddProductToWishListUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Add product to wish list Use Case Implementation</h1>
 *
 * @see AddProductToWishListUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class AddProductToWishListUseCase implements AddProductToWishListUseCasePort {

    // <<-FIELDS->>
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
    public WishList addToWishList(String username, String productCode) {
        Product product = this.productRepositoryPort
                .findByCode(productCode)
                .orElseThrow(() -> new ModelNotFoundException("Product with ID " + productCode + " NOT FOUND"));
        WishList wishList = this.wishlistRepositoryPort
                .findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException("Wish List with customer username " + username + " NOT FOUND"));

        wishList.addProduct(product);

        return this.wishlistRepositoryPort.save(wishList);
    }

}
