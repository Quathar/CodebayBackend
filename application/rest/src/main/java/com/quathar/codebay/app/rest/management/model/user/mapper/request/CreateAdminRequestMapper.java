package com.quathar.codebay.app.rest.management.model.user.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.HttpAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.request.CreateAdminRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Create Administrator Request Mapper</h1>
 *
 * @see HttpAdminRequestMapper
 * @see CreateAdminRequest
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface CreateAdminRequestMapper extends HttpAdminRequestMapper<CreateAdminRequest> {
}
