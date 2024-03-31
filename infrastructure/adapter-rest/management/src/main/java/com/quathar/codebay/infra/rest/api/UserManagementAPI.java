package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.infra.rest.model.request.CreateManagementUserRequest;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateManagementUserRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.rest.model.response.FullUserResponse;
import com.quathar.codebay.infra.rest.model.response.ManagementUserResponse;
import com.quathar.codebay.infra.rest.security.annotation.AuthenticatedAccessByDefault;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.ManagementAPI.MANAGE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User Management API</h1>
 *
 * This interface represents the User Management API, extending the base UserAPI.
 * It provides endpoints and constants related to user management functionality.
 *
 * @see ManagementAPI
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserManagementAPI.ROOT)
//@RequiresAdminRole
@AuthenticatedAccessByDefault
public interface UserManagementAPI {

    // <<-CONSTANT->>
    /**
     * The root path for user management API.
     */
    String ROOT = MANAGE_URL + "/users";

    // <<-METHODS->>
    /**
     * Retrieves all content based on the provided PageContentRequest parameters.
     *
     * @param pageContentRequest The ContentRequest containing parameters for content retrieval.
     * @return A ResponseEntity containing the retrieved content or an error response.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    PageContentResponse<ManagementUserResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The unique identifier of the model.
     * @return ResponseEntity containing the model information if found.
     */
    @GetMapping(path = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    FullUserResponse getById(@PathVariable UUID id);

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user.
     * @return UserManagementResponse containing the user information if found.
     */
    @GetMapping(path = "/username/{username}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ManagementUserResponse getByUsername(@PathVariable String username);

    /**
     * Creates a new user.
     *
     * @param createRequest   The request object containing model information.
     * @return ResponseEntity containing the newly created model information with appropriate status.
     */
    @PostMapping(value = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    ManagementUserResponse signup(@RequestBody @Valid CreateManagementUserRequest createRequest);

    /**
     * Updates an existing user by their unique identifier.
     *
     * @param id            The unique identifier of the model to be updated.
     * @param updateRequest The request object containing updated model information.
     * @return
     */
    @PutMapping(value = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ManagementUserResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid
            UpdateManagementUserRequest updateRequest
    );

    /**
     * Deletes a model by their unique ID.
     *
     * @param id The unique identifier of the model to be deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);

}
