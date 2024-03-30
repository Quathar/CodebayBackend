package com.quathar.codebay.infra.rest.security.factory;

import com.quathar.codebay.infra.rest.security.model.mapper.AuthenticationResponseMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.CreateOperationRequestMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.CreateRoleRequestMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.GrantPermissionRequestMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.GrantedPermissionResponseMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.UpdateOperationRequestMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.UpdateRoleRequestMapper;
import com.quathar.codebay.infra.rest.security.model.mapper.UserDetailsMapper;

import org.mapstruct.factory.Mappers;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Security Factory</h1>
 *
 * @since 2024-03-15
 * @version 1.0
 * @author Q
 */
public interface HttpSecurityFactory {

    // <<-METHODS->>
    /**
     * Retrieves the mapper for user details.
     *
     * @return An instance of {@link UserDetailsMapper}.
     */
    static UserDetailsMapper getUserDetails() {
        return Mappers.getMapper(UserDetailsMapper.class);
    }

    /**
     * Retrieves the mapper for authentication responses.
     *
     * @return An instance of {@link AuthenticationResponseMapper}.
     */
    static AuthenticationResponseMapper getAuthenticationResponse() {
        return Mappers.getMapper(AuthenticationResponseMapper.class);
    }

    /**
     * Retrieves the mapper for creating role requests.
     *
     * @return An instance of {@link CreateRoleRequestMapper}.
     */
    static CreateRoleRequestMapper setCreateRoleRequest() {
        return Mappers.getMapper(CreateRoleRequestMapper.class);
    }

    /**
     * Retrieves the mapper for creating operation requests.
     *
     * @return An instance of {@link CreateOperationRequestMapper}.
     */
    static CreateOperationRequestMapper setCreateOperationRequest() {
        return Mappers.getMapper(CreateOperationRequestMapper.class);
    }

    /**
     * Retrieves the mapper for updating role requests.
     *
     * @return An instance of {@link UpdateRoleRequestMapper}.
     */
    static UpdateRoleRequestMapper setUpdateRoleRequest() {
        return Mappers.getMapper(UpdateRoleRequestMapper.class);
    }

    /**
     * Retrieves the mapper for updating operation requests.
     *
     * @return An instance of {@link UpdateOperationRequestMapper}.
     */
    static UpdateOperationRequestMapper setUpdateOperationRequest() {
        return Mappers.getMapper(UpdateOperationRequestMapper.class);
    }

    /**
     * Retrieves the mapper for granting permission requests.
     *
     * @return An instance of {@link GrantPermissionRequestMapper}.
     */
    static GrantPermissionRequestMapper setGrantPermissionRequest() {
        return Mappers.getMapper(GrantPermissionRequestMapper.class);
    }

    /**
     * Retrieves the mapper for granted permission responses.
     *
     * @return An instance of {@link GrantedPermissionResponseMapper}.
     */
    static GrantedPermissionResponseMapper getGrantedPermissionResponse() {
        return Mappers.getMapper(GrantedPermissionResponseMapper.class);
    }

}
