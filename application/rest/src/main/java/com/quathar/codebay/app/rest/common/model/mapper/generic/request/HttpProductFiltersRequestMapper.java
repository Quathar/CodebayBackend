package com.quathar.codebay.app.rest.common.model.mapper.generic.request;

import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) ProductFilters Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapToModel
 * @see ProductFilters
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpProductFiltersRequestMapper<R> extends MapToModel<R, ProductFilters> {
}
