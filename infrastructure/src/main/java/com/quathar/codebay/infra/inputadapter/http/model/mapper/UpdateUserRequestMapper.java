package com.quathar.codebay.infra.inputadapter.http.model.mapper;

import com.quathar.codebay.infra.inputadapter.http.model.request.UpdateUserRequest;

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
public interface UpdateUserRequestMapper extends UserHttpMapper<UpdateUserRequest> {

    static UpdateUserRequestMapper getInstance() {
        return Mappers.getMapper(UpdateUserRequestMapper.class);
    }

}