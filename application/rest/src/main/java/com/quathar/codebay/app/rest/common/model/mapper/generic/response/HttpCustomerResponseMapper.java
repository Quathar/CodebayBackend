package com.quathar.codebay.app.rest.common.model.mapper.generic.response;

import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Customer Response Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapFromModel
 * @see Customer
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public interface HttpCustomerResponseMapper<R> extends MapFromModel<Customer, R> {
}
