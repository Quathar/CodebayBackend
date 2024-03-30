package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.infra.rest.security.model.request.UpdateRoleRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Update Role Request Mapper</h1>
 *
 * @see UpdateRoleRequest
 * @see HttpRoleMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateRoleRequestMapper extends HttpRoleMapper<UpdateRoleRequest> {
}
