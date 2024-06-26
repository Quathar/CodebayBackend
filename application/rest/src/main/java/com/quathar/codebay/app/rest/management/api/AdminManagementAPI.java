package com.quathar.codebay.app.rest.management.api;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.model.user.request.CreateAdminRequest;
import com.quathar.codebay.app.rest.management.model.user.request.UpdateAdminRequest;
import com.quathar.codebay.app.rest.management.model.user.response.FullAdminResponse;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementAdminResponse;

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

import java.util.UUID;

import static com.quathar.codebay.app.rest.management.api.ManagementAPI.MANAGEMENT_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Administrator API</h1>
 *
 * This interface defines the endpoints related to admin operations.
 *
 * @see ManagementAPI
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(AdminManagementAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT')")
public interface AdminManagementAPI {

    // <<-CONSTANT->>
    /**
     * The root path for administrator management API.
     */
    String ROOT = MANAGEMENT_URL + "/admins";

    // <<-METHODS->>
    /**
     * Retrieves a page of administrators.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of admins.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_ADMINS')")
    @ResponseStatus(OK)
    PageContentResponse<FullAdminResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves an admin by its ID.
     *
     * @param id The ID of the admin to retrieve.
     * @return The admin with the specified ID in a {@link FullAdminResponse}.
     */
    @GetMapping(path = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ADMIN_BY_ID')")
    @ResponseStatus(OK)
    FullAdminResponse getById(@PathVariable UUID id);

    /**
     * Retrieves an admin by its username.
     *
     * @param username The username of the admin to retrieve.
     * @return The admin with the specified username in a {@link ManagementAdminResponse}.
     */
    @GetMapping(path = "/username/{username}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ADMIN_BY_USERNAME')")
    @ResponseStatus(OK)
    ManagementAdminResponse getByUsername(@PathVariable String username);

    /**
     * Retrieves an admin by its authentication token.
     *
     * @return The admin for the specified token in a {@link FullAdminResponse}.
     */
    @GetMapping(path = "/me", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT') AND hasAuthority('READ_MY_PROFILE')")
    @PostAuthorize("returnObject.username == authentication.principal")
    @ResponseStatus(OK)
    FullAdminResponse getProfile();

    /**
     * Creates a new admin.
     *
     * @param createRequest The request body containing details of the admin to create.
     * @return The created admin in a {@link ManagementAdminResponse}.
     */
    @PostMapping(path = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @ResponseStatus(CREATED)
    FullAdminResponse signup(@Valid @RequestBody CreateAdminRequest createRequest);

    /**
     * Updates an existing admin.
     *
     * @param id            The ID of the admin to update.
     * @param updateRequest The request body containing updated details of the admin.
     * @return The updated admin in a {@link ManagementAdminResponse}.
     */
    @PutMapping(path = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @ResponseStatus(OK)
    ManagementAdminResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody
            UpdateAdminRequest updateRequest
    );

    /**
     * Deletes an admin by its ID.
     *
     * @param id The ID of the admin to delete.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
