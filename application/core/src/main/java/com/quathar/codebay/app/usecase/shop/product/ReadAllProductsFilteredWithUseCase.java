package com.quathar.codebay.app.usecase.shop.product;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.domain.port.in.shop.product.ReadAllProductsFilteredWithUseCasePort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read all products filtered with Use Case Implementation</h1>
 *
 * @see ReadAllProductsFilteredWithUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadAllProductsFilteredWithUseCase implements ReadAllProductsFilteredWithUseCasePort {

    // <<-FIELD->>
    /**
     * The product repository port.
     */
    @NonNull
    private final ProductRepositoryPort productRepositoryPort;

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<Product> getAllFilteredWith(ProductFilters filters) {
        return this.productRepositoryPort.findWithFilters(filters);
    }

}
