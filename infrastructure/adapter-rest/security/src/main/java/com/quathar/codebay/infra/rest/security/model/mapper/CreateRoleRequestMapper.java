package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.infra.rest.security.model.request.CreateRoleRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Create Role Request Mapper</h1>
 *
 * @see CreateRoleRequest
 * @see HttpRoleMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateRoleRequestMapper extends HttpRoleMapper<CreateRoleRequest> {
}
