package com.quathar.codebay.domain.port.in.shop.product;

import com.quathar.codebay.domain.model.shop.Product;

/**
 * <h1>Read by code Use Case Port</h1>
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface ReadByCodeUseCasePort {

    /**
     * Retrieves the product identified by the specified unique code.
     *
     * @param code The unique code of the product to retrieve
     * @return The product with the specified code
     */
    Product getByCode(String code);

}
