package com.quathar.codebay.infra.rest.model.mapper;

import com.quathar.codebay.infra.rest.common.model.mapper.HttpUserRequestMapper;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Update User Request Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateUserRequestMapper extends HttpUserRequestMapper<UpdateUserRequest> {
}
