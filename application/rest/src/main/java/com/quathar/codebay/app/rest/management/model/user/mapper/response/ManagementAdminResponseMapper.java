package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.HttpAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementAdminResponse;
import com.quathar.codebay.domain.model.Administrator;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Management Administrator Response Mapper</h1>
 *
 * @see HttpAdminResponseMapper
 * @see ManagementAdminResponse
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ManagementAdminResponseMapper extends HttpAdminResponseMapper<ManagementAdminResponse> {

    @Override
    @Mapping(source = "role.name", target = "role")
    ManagementAdminResponse fromModel(Administrator model);

}
