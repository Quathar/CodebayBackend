package com.quathar.codebay.infra.rest.model.mapper;

import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Create User Request Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateUserRequestMapper extends UserHttpMapper<CreateUserRequest> {

    static CreateUserRequestMapper getInstance() {
        return Mappers.getMapper(CreateUserRequestMapper.class);
    }

}
