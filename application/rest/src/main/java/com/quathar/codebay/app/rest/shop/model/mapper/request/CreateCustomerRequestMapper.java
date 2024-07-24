package com.quathar.codebay.app.rest.shop.model.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.generic.request.HttpCustomerRequestMapper;
import com.quathar.codebay.app.rest.shop.model.request.CreateCustomerRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Create Customer Request Mapper</h1>
 *
 * @see HttpCustomerRequestMapper
 * @see CreateCustomerRequest
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface CreateCustomerRequestMapper extends HttpCustomerRequestMapper<CreateCustomerRequest> {
}
