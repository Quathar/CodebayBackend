package com.quathar.codebay.app.rest.security.model.mapper.request;

import com.quathar.codebay.app.rest.security.model.mapper.HttpPermissionRequestMapper;
import com.quathar.codebay.app.rest.security.model.request.authorization.GrantPermissionRequest;
import com.quathar.codebay.domain.model.security.GrantedPermission;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Granted Permission Request Mapper</h1>
 *
 * @see GrantPermissionRequest
 * @see HttpPermissionRequestMapper
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface GrantPermissionRequestMapper extends HttpPermissionRequestMapper<GrantPermissionRequest> {

    @Override
    @Mapping(source = "role",      target = "role.name")
    @Mapping(source = "operation", target = "operation.name")
    GrantedPermission toModel(GrantPermissionRequest request);

}
