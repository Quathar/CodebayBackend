package com.quathar.codebay.app.rest.shop.model.factory;

import com.quathar.codebay.app.rest.shop.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.UpdateUserRequestMapper;

import static org.mapstruct.factory.Mappers.getMapper;

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
        return getMapper(CreateUserRequestMapper.class);
    }

    static UpdateUserRequestMapper setUpdateUserResponse() {
        return getMapper(UpdateUserRequestMapper.class);
    }

    static BasicUserResponseMapper getBasicUserResponse() {
        return getMapper(BasicUserResponseMapper.class);
    }

}
