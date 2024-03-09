package com.quathar.codebay.infra.rest.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapper;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Update User Request Mapper</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateUserRequestMapper extends ModelMapper<User, UpdateUserRequest> {

    static UpdateUserRequestMapper getInstance() {
        return Mappers.getMapper(UpdateUserRequestMapper.class);
    }

}
