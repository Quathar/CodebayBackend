package com.quathar.codebay.app.rest.common.model.mapper.generic.response;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Product Response Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapFromModel
 * @see Product
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpProductResponseMapper<R> extends MapFromModel<Product, R> {
}
