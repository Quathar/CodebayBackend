package com.quathar.codebay.app.rest.common.model.mapper.generic.request;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Product Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapToModel
 * @see Product
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpProductRequestMapper<R> extends MapToModel<R, Product> {
}
