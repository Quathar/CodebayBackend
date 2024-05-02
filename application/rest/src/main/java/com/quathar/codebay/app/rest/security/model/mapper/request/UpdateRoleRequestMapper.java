package com.quathar.codebay.app.rest.security.model.mapper.request;

import com.quathar.codebay.app.rest.security.model.mapper.HttpRoleRequestMapper;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateRoleRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update Role Request Mapper</h1>
 *
 * @see UpdateRoleRequest
 * @see HttpRoleRequestMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateRoleRequestMapper extends HttpRoleRequestMapper<UpdateRoleRequest> {
}
