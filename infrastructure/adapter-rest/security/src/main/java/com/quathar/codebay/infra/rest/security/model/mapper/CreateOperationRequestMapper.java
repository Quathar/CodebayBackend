package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.infra.rest.security.model.request.CreateOperationRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Create Operation Request Mapper</h1>
 *
 * @see CreateOperationRequest
 * @see HttpOperationMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateOperationRequestMapper extends HttpOperationMapper<CreateOperationRequest> {
}
