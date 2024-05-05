package com.quathar.codebay.app.rest.shop.api;

import com.quathar.codebay.app.rest.shop.model.request.CreateUserRequest;
import com.quathar.codebay.app.rest.shop.model.request.UpdateUserRequest;
import com.quathar.codebay.app.rest.shop.model.response.BasicUserResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User API</h1>
 *
 * This interface defines the endpoints related to user operations.
 *
 * @since 2023-12-12
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserAPI.ROOT)
@PreAuthorize("hasRole('USER')")
public interface UserAPI {

    // <<-CONSTANT->>
    /**
     * The root path for user API.
     */
    String ROOT = BASE_URL + "/users";

    // <<-METHODS->>
    /**
     * Retrieves a model by their username.
     *
     * @param username The username of the user.
     * @return BasicUserResponse containing the basic user information if found.
     */
    @GetMapping(path = "/{username}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_USER_BY_USERNAME')")
    @ResponseStatus(OK)
    BasicUserResponse getByUsername(@PathVariable String username);

    /**
     * Retrieves the profile of the authenticated user.
     *
     * @return BasicUserResponse containing the basic user information if found.
     */
    @GetMapping(path = "/me", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_MY_PROFILE')")
    @ResponseStatus(OK)
    BasicUserResponse getProfile();

    /**
     * Registers a new user.
     *
     * @param createRequest The request body containing the information of the user to be registered.
     * @return BasicUserResponse containing the registered user information.
     */
    @PostMapping(path = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("isAnonymous()")
    @ResponseStatus(CREATED)
    BasicUserResponse signup(@Valid @RequestBody CreateUserRequest createRequest);

    /**
     * Updates an existing user by their username.
     *
     * @param username      The username of the user to be updated.
     * @param updateRequest The request object containing updated user information.
     * @return BasicUserResponse containing the updated user information.
     */
    @PutMapping(path = "/{username}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_MY_PROFILE')")
    @PostAuthorize("returnObject.username == authentication.principal")
    @ResponseStatus(OK)
    BasicUserResponse update(
            @PathVariable String username,
            @Valid @RequestBody
            UpdateUserRequest updateRequest
    );

    /**
     * Deletes a user by their username.
     *
     * @param username The username of the user to be deleted.
     */
    @DeleteMapping("/{username}")
    @PreAuthorize("hasAuthority('DELETE_MY_PROFILE') AND #username == authentication.principal")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable String username);

}
