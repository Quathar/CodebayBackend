package com.quathar.codebay.app.rest.security.model.mapper.request;

import com.quathar.codebay.app.rest.security.model.mapper.HttpOperationRequestMapper;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateOperationRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Create Operation Request Mapper</h1>
 *
 * @see CreateOperationRequest
 * @see HttpOperationRequestMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface CreateOperationRequestMapper extends HttpOperationRequestMapper<CreateOperationRequest> {
}
