package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.infra.rest.model.request.CreateManagementUserRequest;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateManagementUserRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.rest.model.response.FullAdminResponse;
import com.quathar.codebay.infra.rest.model.response.FullUserResponse;
import com.quathar.codebay.infra.rest.model.response.ManagementAdminResponse;
import com.quathar.codebay.infra.rest.model.response.ManagementUserResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.ManagementAPI.MANAGEMENT_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User Management API</h1>
 *
 * This interface defines the endpoints related to user management operations.
 *
 * @see ManagementAPI
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserManagementAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT')")
public interface UserManagementAPI {

    // <<-CONSTANT->>
    /**
     * The root path for user management API.
     */
    String ROOT = MANAGEMENT_URL + "/users";

    // <<-METHODS->>
    /**
     * Retrieves a page of users for management.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of users.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_USERS')")
    @ResponseStatus(OK)
    PageContentResponse<ManagementUserResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID in a {@link FullUserResponse}.
     *
     */
    @GetMapping(path = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_USER_BY_ID')")
    @ResponseStatus(OK)
    FullUserResponse getById(@PathVariable UUID id);

    /**
     * Retrieves a user by its username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the specified username in a {@link ManagementUserResponse}.
     */
    @GetMapping(path = "/username/{username}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT') AND hasAuthority('READ_USER_BY_USERNAME')")
    @ResponseStatus(OK)
    ManagementUserResponse getByUsername(@PathVariable String username);

    /**
     * Creates a new user from management area.
     *
     * @param createRequest The request body containing details of the user to create.
     * @return The created user in a {@link ManagementUserResponse}.
     */
    @PostMapping(path = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CREATE_USER')")
    @ResponseStatus(CREATED)
    ManagementUserResponse signup(@RequestBody @Valid CreateManagementUserRequest createRequest);

    /**
     * Updates an existing user.
     *
     * @param id            The ID of the user to update.
     * @param updateRequest The request body containing updated details of the user.
     * @return The updated user in a {@link ManagementAdminResponse}.
     */
    @PutMapping(path = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @ResponseStatus(OK)
    ManagementUserResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid
            UpdateManagementUserRequest updateRequest
    );

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
