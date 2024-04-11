package com.quathar.codebay.infra.rest.management.model.mapper.user.admin;

import com.quathar.codebay.infra.rest.common.model.mapper.HttpAdminRequestMapper;
import com.quathar.codebay.infra.rest.management.model.request.UpdateAdminRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Update Administrator Request Mapper</h1>
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateAdminRequestMapper extends HttpAdminRequestMapper<UpdateAdminRequest> {
}
