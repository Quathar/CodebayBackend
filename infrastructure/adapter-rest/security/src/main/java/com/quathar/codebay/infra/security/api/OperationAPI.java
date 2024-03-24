package com.quathar.codebay.infra.security.api;

import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.security.model.request.CreateOperationRequest;
import com.quathar.codebay.infra.security.model.request.UpdateOperationRequest;

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

import static com.quathar.codebay.infra.security.api.SecurityAPI.SECURITY_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Operation API</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RequestMapping(OperationAPI.ROOT)
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
    @ResponseStatus(HttpStatus.OK)
    PageContentResponse<Operation> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves an operation by its ID.
     *
     * @param id The ID of the operation to retrieve.
     * @return The {@link Operation} with the specified ID.
     */
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.CREATED)
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
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);

}
