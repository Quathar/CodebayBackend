package com.quathar.codebay.infra.rest.security.api;

import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.rest.security.model.request.CreateRoleRequest;
import com.quathar.codebay.infra.rest.security.model.request.UpdateRoleRequest;

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

import static com.quathar.codebay.infra.rest.security.api.SecurityAPI.SECURITY_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Role API</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RequestMapping(RoleAPI.ROOT)
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
    @ResponseStatus(HttpStatus.OK)
    PageContentResponse<Role> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a role by its ID.
     *
     * @param id The ID of the role to retrieve.
     * @return The {@link Role} with the specified ID.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    Role getById(@PathVariable UUID id);

    /**
     * Creates a new role.
     *
     * @param createRoleRequest The request body containing details of the role to create.
     * @return The created {@link Role}.
     */
    @PostMapping(path = "/create",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    Role create(@RequestBody @Valid CreateRoleRequest createRoleRequest);

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
    @ResponseStatus(HttpStatus.OK)
    Role update(
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);

}
