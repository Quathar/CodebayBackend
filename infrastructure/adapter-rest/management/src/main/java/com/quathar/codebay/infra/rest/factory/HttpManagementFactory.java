package com.quathar.codebay.infra.rest.factory;

import com.quathar.codebay.infra.rest.model.mapper.user.CreateManagementUserRequestMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.FullUserResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.ManagementUserResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.UpdateManagementUserRequestMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.admin.CreateAdminRequestMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.admin.FullAdminResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.admin.ManagementAdminResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.user.admin.UpdateAdminRequestMapper;

import org.mapstruct.factory.Mappers;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Mapper Manager</h1>
 *
 * Manages and provides instances of different mappers.<br>
 * <br>
 * This abstract class serves as a manager for various mapper instances.
 * It allows retrieval of specific mapper instances based on the provided Class.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpManagementFactory {

    // <<-USER->>
    static FullUserResponseMapper getFullUserResponse() {
        return Mappers.getMapper(FullUserResponseMapper.class);
    }

    static ManagementUserResponseMapper getManagementUserResponse() {
        return Mappers.getMapper(ManagementUserResponseMapper.class);
    }

    static CreateManagementUserRequestMapper setCreateManagementUserRequest() {
        return Mappers.getMapper(CreateManagementUserRequestMapper.class);
    }

    static UpdateManagementUserRequestMapper setUpdateManagementUserRequest() {
        return Mappers.getMapper(UpdateManagementUserRequestMapper.class);
    }

    // <<-ADMIN->>
    static FullAdminResponseMapper getFullAdminResponse() {
        return Mappers.getMapper(FullAdminResponseMapper.class);
    }

    static ManagementAdminResponseMapper getManagementAdminResponse() {
        return Mappers.getMapper(ManagementAdminResponseMapper.class);
    }

    static CreateAdminRequestMapper setCreateAdminRequest() {
        return Mappers.getMapper(CreateAdminRequestMapper.class);
    }

    static UpdateAdminRequestMapper setUpdateAdminRequest() {
        return Mappers.getMapper(UpdateAdminRequestMapper.class);
    }

}
