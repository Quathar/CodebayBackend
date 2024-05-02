package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.HttpUserResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementUserResponse;
import com.quathar.codebay.domain.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Management User Response Mapper</h1>
 *
 * @see HttpUserResponseMapper
 * @see ManagementUserResponse
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ManagementUserResponseMapper extends HttpUserResponseMapper<ManagementUserResponse> {

    @Override
    @Mapping(source = "role.name", target = "role")
    ManagementUserResponse fromModel(User model);

}
