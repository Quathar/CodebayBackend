package com.quathar.codebay.app.rest.security.api.authorization;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateOperationRequest;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateOperationRequest;
import com.quathar.codebay.domain.model.security.Operation;

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
 * <h1>Operation API</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RequestMapping(OperationAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN')")
public interface OperationAPI {

    // <<-CONSTANT->>
    /**
     * The root path for Operation API.
     */
    String ROOT = SECURITY_URL + "/operations";

    // <<-METHODS->>
    /**
     * Retrieves a page of operations.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of operations.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_OPERATIONS')")
    @ResponseStatus(OK)
    PageContentResponse<Operation> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves an operation by its ID.
     *
     * @param id The ID of the operation to retrieve.
     * @return The {@link Operation} with the specified ID.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_OPERATION')")
    @ResponseStatus(OK)
    Operation getById(@PathVariable UUID id);

    /**
     * Creates a new operation.
     *
     * @param createOperationRequest The request body containing details of the operation to create.
     * @return The created {@link Operation}
     */
    @PostMapping(path = "/create",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CREATE_OPERATION')")
    @ResponseStatus(CREATED)
    Operation create(@RequestBody @Valid CreateOperationRequest createOperationRequest);

    /**
     * Updates an existing operation.
     *
     * @param id The ID of the operation to update.
     * @param updateOperationRequest The request body containing updated details of the operation.
     * @return The updated {@link Operation}
     */
    @PutMapping(path = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_OPERATION')")
    @ResponseStatus(OK)
    Operation update(
            @PathVariable UUID id,
            @RequestBody @Valid
            UpdateOperationRequest updateOperationRequest
    );

    /**
     * Deletes an operation by its ID.
     *
     * @param id The ID of the operation to delete.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_OPERATION')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
