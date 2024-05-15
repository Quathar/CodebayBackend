package com.quathar.codebay.app.usecase.shop.cart;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.ReadCartByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read shopping cart by username Use Case Implementation</h1>
 *
 * @see ReadCartByUsernameUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadCartByUsernameUseCase implements ReadCartByUsernameUseCasePort {

    // <<-FIELD->>
    /**
     * The shopping cart repository port.
     */
    @NonNull
    private final ShoppingCartRepositoryPort cartRepositoryPort;

    // <<-METHOD->>
    @Override
    public ShoppingCart getCartByUsername(String username) {
        return this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
    }

}
