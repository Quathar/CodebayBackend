package com.quathar.codebay.infra.rest.management.model.mapper.user.admin;

import com.quathar.codebay.infra.rest.common.model.mapper.HttpAdminResponseMapper;
import com.quathar.codebay.infra.rest.management.model.response.ManagementAdminResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Management Administrator Response Mapper</h1>
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagementAdminResponseMapper extends HttpAdminResponseMapper<ManagementAdminResponse> {
}
