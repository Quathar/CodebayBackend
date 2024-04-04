package com.quathar.codebay.infra.rest.management.model.mapper.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.common.model.mapper.HttpUserResponseMapper;
import com.quathar.codebay.infra.rest.management.model.response.FullUserResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Full User Response Mapper</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FullUserResponseMapper extends HttpUserResponseMapper<FullUserResponse> {

    @Override
    @Mapping(source = "role.name", target = "role")
    FullUserResponse fromModel(User model);

}
