package com.quathar.codebay.app.rest.security.model.mapper.request;

import com.quathar.codebay.app.rest.security.model.mapper.HttpOperationRequestMapper;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateOperationRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update Operation Request Mapper</h1>
 *
 * @see UpdateOperationRequest
 * @see HttpOperationRequestMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateOperationRequestMapper extends HttpOperationRequestMapper<UpdateOperationRequest> {
}