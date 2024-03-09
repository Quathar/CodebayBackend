package com.quathar.codebay.infra.rest.model.mapper;

import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Basic Admin Response Mapper</h1>
 *
 * @since 2024-02-04
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasicAdminResponseMapper extends com.quathar.codebay.application.commonport.ModelMapper<com.quathar.codebay.domain.model.Administrator, BasicUserResponse> {

    static BasicAdminResponseMapper getInstance() {
        return Mappers.getMapper(BasicAdminResponseMapper.class);
    }

}
