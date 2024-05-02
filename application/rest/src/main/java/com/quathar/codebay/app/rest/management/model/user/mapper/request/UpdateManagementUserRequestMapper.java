package com.quathar.codebay.app.rest.management.model.user.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.HttpUserRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.request.UpdateManagementUserRequest;
import com.quathar.codebay.domain.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update Management User Request Mapper</h1>
 *
 * @see HttpUserRequestMapper
 * @see UpdateManagementUserRequest
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateManagementUserRequestMapper extends HttpUserRequestMapper<UpdateManagementUserRequest> {

    @Override
    @Mapping(source = "role", target = "role.name")
    User toModel(UpdateManagementUserRequest other);

}
