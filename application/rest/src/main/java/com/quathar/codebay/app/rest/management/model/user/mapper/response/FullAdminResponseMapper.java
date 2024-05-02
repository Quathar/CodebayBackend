package com.quathar.codebay.app.rest.management.model.user.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.HttpAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.mapper.AuditResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.response.FullAdminResponse;
import com.quathar.codebay.domain.model.Administrator;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Full Administrator Response Mapper</h1>
 *
 * @see HttpAdminResponseMapper
 * @see FullAdminResponse
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(uses = AuditResponseMapper.class, unmappedTargetPolicy = IGNORE)
public interface FullAdminResponseMapper extends HttpAdminResponseMapper<FullAdminResponse> {

    @Override
    @Mapping(source = "role.name", target = "role")
    FullAdminResponse fromModel(Administrator model);

}
