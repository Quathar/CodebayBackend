package com.quathar.codebay.app.rest.shop.model.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.generic.request.HttpCustomerRequestMapper;
import com.quathar.codebay.app.rest.shop.model.request.UpdateCustomerRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update Customer Request Mapper</h1>
 *
 * @see HttpCustomerRequestMapper
 * @see UpdateCustomerRequest
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateCustomerRequestMapper extends HttpCustomerRequestMapper<UpdateCustomerRequest> {
}
