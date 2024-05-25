package com.quathar.codebay.app.rest.common.model.mapper.generic.request;

import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Customer Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapToModel
 * @see Customer
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpCustomerRequestMapper<R> extends MapToModel<R, Customer> {
}
