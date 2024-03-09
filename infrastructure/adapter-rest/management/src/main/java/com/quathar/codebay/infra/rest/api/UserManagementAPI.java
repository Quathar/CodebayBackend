package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.api.crud.CreateModelEndpoint;
import com.quathar.codebay.infra.rest.api.crud.DeleteModelEndpoint;
import com.quathar.codebay.infra.rest.api.crud.RetrieveAllModelsEndpoint;
import com.quathar.codebay.infra.rest.api.crud.RetrieveModelEndpoint;
import com.quathar.codebay.infra.rest.api.crud.UpdateModelEndpoint;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.quathar.codebay.infra.rest.api.ManagementAPI.MANAGE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User Management API</h1>
 * <br>
 * <p>
 *     This interface represents the User Management API, extending the base UserAPI.
 *     It provides endpoints and constants related to user management functionality.
 * </p>
 *
 * @see BaseAPI
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserManagementAPI.MANAGEMENT_ROOT)
public interface UserManagementAPI
       extends RetrieveAllModelsEndpoint<User>,
               RetrieveModelEndpoint<User>,
               CreateModelEndpoint<CreateUserRequest, User>,
               UpdateModelEndpoint<UpdateUserRequest, User>,
               DeleteModelEndpoint {

    /**
     * The root path for user management API.
     */
    String MANAGEMENT_ROOT = MANAGE_URL + "/users";

}
