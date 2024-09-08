package com.quathar.codebay.domain.port.in.shop.product;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ProductFilters;

/**
 * <h1>Read all products filtered with Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ReadAllProductsFilteredWithUseCasePort {

    /**
     * Retrieves all products filtered with the specified criteria.
     *
     * @param filters The filters to apply for retrieving products
     * @return A stream of products filtered with the specified criteria
     */
    java.util.stream.Stream<Product> getAllFilteredWith(ProductFilters filters);

}
