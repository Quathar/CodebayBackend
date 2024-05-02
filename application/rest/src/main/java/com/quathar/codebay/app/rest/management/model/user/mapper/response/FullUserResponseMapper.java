package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.HttpUserResponseMapper;
import com.quathar.codebay.app.rest.management.model.mapper.AuditResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.FullUserResponse;
import com.quathar.codebay.domain.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Full User Response Mapper</h1>
 *
 * @see HttpUserResponseMapper
 * @see FullUserResponse
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
@Mapper(uses = AuditResponseMapper.class, unmappedTargetPolicy = IGNORE)
public interface FullUserResponseMapper extends HttpUserResponseMapper<FullUserResponse> {

    @Override
    @Mapping(source = "role.name", target = "role")
    FullUserResponse fromModel(User model);

}
