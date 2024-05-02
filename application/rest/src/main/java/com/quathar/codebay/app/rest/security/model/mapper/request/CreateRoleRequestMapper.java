package com.quathar.codebay.app.rest.security.model.mapper.request;

import com.quathar.codebay.app.rest.security.model.mapper.HttpRoleRequestMapper;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateRoleRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Create Role Request Mapper</h1>
 *
 * @see CreateRoleRequest
 * @see HttpRoleRequestMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface CreateRoleRequestMapper extends HttpRoleRequestMapper<CreateRoleRequest> {
}