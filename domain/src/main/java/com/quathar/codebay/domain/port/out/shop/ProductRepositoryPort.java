package com.quathar.codebay.domain.port.out.shop;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

/**
 * <h1>Product Repository Port</h1>
 *
 * @see CrudRepositoryPort
 * @see Product
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ProductRepositoryPort
       extends   CrudRepositoryPort<Product, java.util.UUID> {

    /**
     * Retrieves products that match the specified filters.
     *
     * @param filters The filters to apply for retrieving products
     * @return A stream of products filtered with the specified criteria
     */
    java.util.stream.Stream<Product> findWithFilters(ProductFilters filters);

    /**
     * Retrieves a product by its unique code.
     *
     * @param code The unique code of the product to retrieve
     * @return An optional containing the product with the specified code, or empty if not found
     */
    java.util.Optional<Product> findByCode(String code);

}
