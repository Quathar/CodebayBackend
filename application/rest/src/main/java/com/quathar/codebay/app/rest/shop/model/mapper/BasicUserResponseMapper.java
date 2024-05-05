package com.quathar.codebay.app.rest.shop.model.mapper;

import com.quathar.codebay.app.rest.common.model.mapper.HttpUserResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicUserResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic User Response Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface BasicUserResponseMapper extends HttpUserResponseMapper<BasicUserResponse> {
}
