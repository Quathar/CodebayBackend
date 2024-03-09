package com.quathar.codebay.infra.rest.model.mapper;

import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Basic User Response Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasicUserResponseMapper extends UserHttpMapper<BasicUserResponse> {

    static BasicUserResponseMapper getInstance() {
        return Mappers.getMapper(BasicUserResponseMapper.class);
    }

}
