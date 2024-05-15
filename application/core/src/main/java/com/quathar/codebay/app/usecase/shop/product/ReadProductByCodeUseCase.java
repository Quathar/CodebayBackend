package com.quathar.codebay.app.usecase.shop.product;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.port.in.shop.product.ReadByCodeUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read product by code Use Case Implementation</h1>
 *
 * @see ReadByCodeUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadProductByCodeUseCase implements ReadByCodeUseCasePort {

    // <<-FIELD->>
    /**
     * The product repository port.
     */
    @NonNull
    private final ProductRepositoryPort productRepositoryPort;

    // <<-METHOD->>
    @Override
    public Product getByCode(String code) {
        return this.productRepositoryPort
                .findByCode(code)
                .orElseThrow(ModelNotFoundException::new);
    }

}
