package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpCustomerResponseMapper;
import com.quathar.codebay.app.rest.management.model.mapper.AuditResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.FullCustomerResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Full Customer Response Mapper</h1>
 *
 * @see HttpCustomerResponseMapper
 * @see FullCustomerResponse
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
@Mapper(uses = AuditResponseMapper.class, unmappedTargetPolicy = IGNORE)
public interface FullCustomerResponseMapper extends HttpCustomerResponseMapper<FullCustomerResponse> {
}
