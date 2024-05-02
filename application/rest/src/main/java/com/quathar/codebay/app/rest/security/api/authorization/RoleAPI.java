package com.quathar.codebay.app.rest.security.api.authorization;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateRoleRequest;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateRoleRequest;
import com.quathar.codebay.app.rest.security.model.response.RoleResponse;
import com.quathar.codebay.domain.model.security.Role;

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

import static com.quathar.codebay.app.rest.security.api.SecurityAPI.SECURITY_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Role API</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RequestMapping(RoleAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN')")
public interface RoleAPI {

    // <<-CONSTANT->>
    /**
     * The root path for Role API.
     */
    String ROOT = SECURITY_URL + "/roles";

    // <<-METHODS->>
    /**
     * Retrieves a page of roles.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of roles.
     */
    @GetMapping(path = "",  produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_ROLES')")
    @ResponseStatus(OK)
    PageContentResponse<RoleResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a role by its ID.
     *
     * @param id The ID of the role to retrieve.
     * @return The {@link Role} with the specified ID.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ROLE')")
    @ResponseStatus(OK)
    RoleResponse getById(@PathVariable UUID id);

    /**
     * Creates a new role.
     *
     * @param createRoleRequest The request body containing details of the role to create.
     * @return The created {@link Role}.
     */
    @PostMapping(path = "/create",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    @ResponseStatus(CREATED)
    RoleResponse create(@RequestBody @Valid CreateRoleRequest createRoleRequest);

    /**
     * Updates an existing role.
     *
     * @param id The ID of the role to update.
     * @param updateRoleRequest The request body containing updated details of the role.
     * @return The updated {@link Role}.
     */
    @PutMapping(path = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    @ResponseStatus(OK)
    RoleResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid
            UpdateRoleRequest updateRoleRequest
    );

    /**
     * Deletes a role by its ID.
     *
     * @param id The ID of the role to delete.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
