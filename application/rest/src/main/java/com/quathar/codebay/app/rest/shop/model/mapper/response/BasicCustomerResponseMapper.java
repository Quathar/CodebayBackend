package com.quathar.codebay.app.rest.shop.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpCustomerResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicCustomerResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic Customer Response Mapper</h1>
 *
 * @see HttpCustomerResponseMapper
 * @see BasicCustomerResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface BasicCustomerResponseMapper extends HttpCustomerResponseMapper<BasicCustomerResponse> {
}
