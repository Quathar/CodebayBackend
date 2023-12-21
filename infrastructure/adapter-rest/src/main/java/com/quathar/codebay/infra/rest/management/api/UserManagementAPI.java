package com.quathar.codebay.infra.rest.management.api;

import com.quathar.codebay.infra.rest.api.UserAPI;

import com.quathar.codebay.infra.rest.model.request.PageContentRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.quathar.codebay.infra.rest.management.api.ManagementAPI.MANAGE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
@RequestMapping(UserManagementAPI.MANAGEMENT_ROOT)
public interface UserManagementAPI extends UserAPI {

    /**
     * The root path for user management API.
     */
    String MANAGEMENT_ROOT = MANAGE_URL + "/users";

    /**
     * Retrieves all content based on the provided ContentRequest parameters.
     *
     * @param pageContentRequest The ContentRequest containing parameters for content retrieval.
     * @return A ResponseEntity containing the retrieved content or an error response.
     */
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAll(@Valid PageContentRequest pageContentRequest);

}
