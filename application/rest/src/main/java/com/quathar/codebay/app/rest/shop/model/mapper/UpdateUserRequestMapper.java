package com.quathar.codebay.app.rest.shop.model.mapper;

import com.quathar.codebay.app.rest.common.model.mapper.HttpUserRequestMapper;
import com.quathar.codebay.app.rest.shop.model.request.UpdateUserRequest;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update User Request Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateUserRequestMapper extends HttpUserRequestMapper<UpdateUserRequest> {
}
