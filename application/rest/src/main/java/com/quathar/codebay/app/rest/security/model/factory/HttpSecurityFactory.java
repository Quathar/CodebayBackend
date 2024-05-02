package com.quathar.codebay.app.rest.security.model.factory;

import com.quathar.codebay.app.rest.security.model.mapper.request.CreateOperationRequestMapper;
import com.quathar.codebay.app.rest.security.model.mapper.request.CreateRoleRequestMapper;
import com.quathar.codebay.app.rest.security.model.mapper.request.GrantPermissionRequestMapper;
import com.quathar.codebay.app.rest.security.model.mapper.request.UpdateOperationRequestMapper;
import com.quathar.codebay.app.rest.security.model.mapper.request.UpdateRoleRequestMapper;
import com.quathar.codebay.app.rest.security.model.mapper.response.AuthenticationResponseMapper;
import com.quathar.codebay.app.rest.security.model.mapper.response.GrantedPermissionResponseMapper;
import com.quathar.codebay.app.rest.security.model.mapper.response.RoleResponseMapper;

import static org.mapstruct.factory.Mappers.getMapper;

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
     * Retrieves the mapper for authentication responses.
     *
     * @return An instance of {@link AuthenticationResponseMapper}.
     */
    static AuthenticationResponseMapper getAuthenticationResponse() {
        return getMapper(AuthenticationResponseMapper.class);
    }

    // <<-ROLE->>
    /**
     * Retrieves the mapper for creating role requests.
     *
     * @return An instance of {@link CreateRoleRequestMapper}.
     */
    static CreateRoleRequestMapper setCreateRoleRequest() {
        return getMapper(CreateRoleRequestMapper.class);
    }

    /**
     * Retrieves the mapper for updating role requests.
     *
     * @return An instance of {@link UpdateRoleRequestMapper}.
     */
    static UpdateRoleRequestMapper setUpdateRoleRequest() {
        return getMapper(UpdateRoleRequestMapper.class);
    }

    static RoleResponseMapper getRoleResponse() {
        return getMapper(RoleResponseMapper.class);
    }

    // <<-OPERATION->>
    /**
     * Retrieves the mapper for creating operation requests.
     *
     * @return An instance of {@link CreateOperationRequestMapper}.
     */
    static CreateOperationRequestMapper setCreateOperationRequest() {
        return getMapper(CreateOperationRequestMapper.class);
    }

    /**
     * Retrieves the mapper for updating operation requests.
     *
     * @return An instance of {@link UpdateOperationRequestMapper}.
     */
    static UpdateOperationRequestMapper setUpdateOperationRequest() {
        return getMapper(UpdateOperationRequestMapper.class);
    }

    // <<-PERMISSION->>
    /**
     * Retrieves the mapper for granting permission requests.
     *
     * @return An instance of {@link GrantPermissionRequestMapper}.
     */
    static GrantPermissionRequestMapper setGrantPermissionRequest() {
        return getMapper(GrantPermissionRequestMapper.class);
    }

    /**
     * Retrieves the mapper for granted permission responses.
     *
     * @return An instance of {@link GrantedPermissionResponseMapper}.
     */
    static GrantedPermissionResponseMapper getGrantedPermissionResponse() {
        return getMapper(GrantedPermissionResponseMapper.class);
    }

}
