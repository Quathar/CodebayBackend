package com.quathar.codebay.infra.rest.admin.api;

import com.quathar.codebay.infra.rest.api.UserAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.quathar.codebay.infra.rest.admin.api.AdminAPI.BASE_URL;

/**
 * <h1>User Management API</h1>
 * <br>
 * <p>
 *     This interface represents the User Management API, extending the base UserAPI.
 *     It provides endpoints and constants related to user management functionality.
 * </p>
 *
 * @see UserAPI
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserManagementAPI.ROOT)
public interface UserManagementAPI extends UserAPI {

    /**
     * The root path for user management API.
     */
    String ROOT = BASE_URL + "/users";

    @GetMapping
    ResponseEntity<?> getAll();

}
