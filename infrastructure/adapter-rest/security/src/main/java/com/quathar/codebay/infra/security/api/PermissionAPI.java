package com.quathar.codebay.infra.security.api;

import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.security.model.request.GrantPermissionRequest;
import com.quathar.codebay.infra.security.model.response.GrantedPermissionResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.infra.security.api.SecurityAPI.SECURITY_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Permission API</h1>
 *
 * API endpoints for managing permissions.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RequestMapping(PermissionAPI.ROOT)
public interface PermissionAPI {

    // <<-CONSTANT->>
    /**
     * The root path for Permission API.
     */
    String ROOT = SECURITY_URL + "/permissions";

    // <<-METHODS->>
    /**
     * Retrieves a page of granted permissions.
     *
     * @param pageContentRequest The page content request.
     * @return A {@link PageContentResponse} containing a list of {@link GrantedPermissionResponse}.
     */
    @GetMapping(path = "",  produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    PageContentResponse<GrantedPermissionResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a page of granted permissions grouped by role.
     *
     * @return A {@link PageContentResponse} containing a list of {@link RoleOperations}.
     */
    @GetMapping(path = "/by-role",  produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    PageContentResponse<RoleOperations> getAllGroupedByRole();

    /**
     * Retrieves a granted permission by its ID.
     *
     * @param id The ID of the granted permission to retrieve.
     * @return A {@link GrantedPermissionResponse}.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    GrantedPermissionResponse getById(@PathVariable UUID id);

    /**
     * Grants a new permission.
     *
     * @param grantPermissionRequest The request body containing details of the permission to grant.
     * @return A {@link GrantedPermissionResponse}.
     */
    @PostMapping(path = "/grant",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    GrantedPermissionResponse grant(
            @RequestBody @Valid
            GrantPermissionRequest grantPermissionRequest
    );

    /**
     * Deletes a granted permission by its ID.
     *
     * @param id The ID of the granted permission to delete.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);

}
