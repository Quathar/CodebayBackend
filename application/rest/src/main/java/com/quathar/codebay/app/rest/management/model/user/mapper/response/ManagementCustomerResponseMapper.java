package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpCustomerResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementCustomerResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Management Customer Response Mapper</h1>
 *
 * @see HttpCustomerResponseMapper
 * @see ManagementCustomerResponse
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ManagementCustomerResponseMapper extends HttpCustomerResponseMapper<ManagementCustomerResponse> {
}
