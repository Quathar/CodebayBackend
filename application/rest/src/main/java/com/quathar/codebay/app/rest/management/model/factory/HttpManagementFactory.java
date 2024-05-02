package com.quathar.codebay.app.rest.management.model.factory;

import com.quathar.codebay.app.rest.management.model.user.mapper.request.CreateAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.CreateManagementUserRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.UpdateAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.UpdateManagementUserRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.FullAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.FullUserResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.ManagementAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.ManagementUserResponseMapper;

import static org.mapstruct.factory.Mappers.getMapper;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Management Factory</h1>
 *
 * Manages and provides instances of different mappers.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpManagementFactory {

    // <<-USER->>
    static FullUserResponseMapper getFullUserResponse() {
        return getMapper(FullUserResponseMapper.class);
    }

    static ManagementUserResponseMapper getManagementUserResponse() {
        return getMapper(ManagementUserResponseMapper.class);
    }

    static CreateManagementUserRequestMapper setCreateManagementUserRequest() {
        return getMapper(CreateManagementUserRequestMapper.class);
    }

    static UpdateManagementUserRequestMapper setUpdateManagementUserRequest() {
        return getMapper(UpdateManagementUserRequestMapper.class);
    }

    // <<-ADMIN->>
    static FullAdminResponseMapper getFullAdminResponse() {
        return getMapper(FullAdminResponseMapper.class);
    }

    static ManagementAdminResponseMapper getManagementAdminResponse() {
        return getMapper(ManagementAdminResponseMapper.class);
    }

    static CreateAdminRequestMapper setCreateAdminRequest() {
        return getMapper(CreateAdminRequestMapper.class);
    }

    static UpdateAdminRequestMapper setUpdateAdminRequest() {
        return getMapper(UpdateAdminRequestMapper.class);
    }

}
