package com.quathar.codebay.app.usecase.shop.wishlist;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.shop.wishlist.ReadWishListByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read wish list by username Use Case Implementation</h1>
 *
 * @see ReadWishListByUsernameUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadWishListByUsernameUseCase implements ReadWishListByUsernameUseCasePort {

    // <<-FIELD->>
    /**
     * The wish list repository port.
     */
    @NonNull
    private final WishListRepositoryPort wishListRepositoryPort;

    // <<-METHOD->>
    @Override
    public WishList getWishListByUsername(String username) {
        return this.wishListRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
    }

}
