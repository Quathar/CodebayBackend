package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.infra.rest.security.model.response.GrantedPermissionResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Granted Permission Response Mapper</h1>
 *
 * @see GrantedPermissionResponse
 * @see HttpPermissionMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GrantedPermissionResponseMapper extends HttpPermissionMapper<GrantedPermissionResponse> {

    @Override
    @Mapping(source = "role.name",      target = "role")
    @Mapping(source = "operation.name", target = "operation")
    GrantedPermissionResponse fromModel(GrantedPermission model);

    @Override
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "operation", ignore = true)
    GrantedPermission toModel(GrantedPermissionResponse response);

}
