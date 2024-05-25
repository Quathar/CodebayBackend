package com.quathar.codebay.app.rest.common.model.mapper.generic.response;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Order Response Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapFromModel
 * @see Order
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpOrderResponseMapper<R> extends MapFromModel<Order, R> {
}
