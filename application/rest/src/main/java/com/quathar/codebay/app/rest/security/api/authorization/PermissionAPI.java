package com.quathar.codebay.app.rest.security.api.authorization;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.model.request.authorization.GrantPermissionRequest;
import com.quathar.codebay.app.rest.security.model.response.GrantedPermissionResponse;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.app.rest.security.api.SecurityAPI.SECURITY_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
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
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN')")
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
    @PreAuthorize("hasAuthority('READ_ALL_GRANTED_PERMISSIONS')")
    @ResponseStatus(OK)
    PageContentResponse<GrantedPermissionResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a page of granted permissions grouped by role.
     *
     * @return A {@link PageContentResponse} containing a list of {@link RoleOperations}.
     */
    @GetMapping(path = "/by-role",  produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_GRANTED_PERMISSIONS')")
    @ResponseStatus(OK)
    PageContentResponse<RoleOperations> getAllGroupedByRole();

    /**
     * Retrieves a granted permission by its ID.
     *
     * @param id The ID of the granted permission to retrieve.
     * @return A {@link GrantedPermissionResponse}.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_GRANTED_PERMISSION')")
    @ResponseStatus(OK)
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
    @PreAuthorize("hasAuthority('GRANT_PERMISSION')")
    @ResponseStatus(CREATED)
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
    @PreAuthorize("hasAuthority('REVOKE_GRANTED_PERMISSION')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
