package com.quathar.codebay.infra.rest.factory;

import com.quathar.codebay.infra.rest.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.infra.rest.model.mapper.UpdateUserRequestMapper;

import org.mapstruct.factory.Mappers;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Shop Factory</h1>
 *
 * Manages and provides instances of different mappers.
 * <br>
 * This abstract class serves as a manager for various mapper instances.
 * It allows retrieval of specific mapper instances based on the provided Class.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpShopFactory {

    static CreateUserRequestMapper setCreateUserRequest() {
        return Mappers.getMapper(CreateUserRequestMapper.class);
    }

    static UpdateUserRequestMapper setUpdateUserResponse() {
        return Mappers.getMapper(UpdateUserRequestMapper.class);
    }

    static BasicUserResponseMapper getBasicUserResponse() {
        return Mappers.getMapper(BasicUserResponseMapper.class);
    }

}
