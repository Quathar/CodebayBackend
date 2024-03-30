package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.infra.rest.security.model.request.GrantPermissionRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Granted Permission Request Mapper</h1>
 *
 * @see GrantPermissionRequest
 * @see HttpPermissionMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GrantPermissionRequestMapper extends HttpPermissionMapper<GrantPermissionRequest> {

    @Override
    @Mapping(source = "role",      target = "role.name")
    @Mapping(source = "operation", target = "operation.name")
    GrantedPermission toModel(GrantPermissionRequest request);

    @Override
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "operation", ignore = true)
    GrantPermissionRequest fromModel(GrantedPermission model);

}
