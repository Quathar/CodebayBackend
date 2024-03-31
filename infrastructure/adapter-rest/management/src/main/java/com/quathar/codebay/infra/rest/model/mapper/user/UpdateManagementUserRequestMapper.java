package com.quathar.codebay.infra.rest.model.mapper.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.common.model.mapper.HttpUserRequestMapper;
import com.quathar.codebay.infra.rest.model.request.UpdateManagementUserRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Update Management User Request Mapper</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateManagementUserRequestMapper extends HttpUserRequestMapper<UpdateManagementUserRequest> {

    @Override
    @Mapping(source = "role", target = "role.name")
    User toModel(UpdateManagementUserRequest other);

}
