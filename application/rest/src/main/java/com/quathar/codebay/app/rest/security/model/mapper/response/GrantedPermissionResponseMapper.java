package com.quathar.codebay.app.rest.security.model.mapper.response;

import com.quathar.codebay.app.rest.security.model.response.GrantedPermissionResponse;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Granted Permission Response Mapper</h1>
 *
 * @see GrantedPermissionResponse
 * @see MapFromModel
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface GrantedPermissionResponseMapper extends MapFromModel<GrantedPermission, GrantedPermissionResponse> {

    @Override
    @Mapping(source = "role.name",      target = "role")
    @Mapping(source = "operation.name", target = "operation")
    GrantedPermissionResponse fromModel(GrantedPermission model);

}
