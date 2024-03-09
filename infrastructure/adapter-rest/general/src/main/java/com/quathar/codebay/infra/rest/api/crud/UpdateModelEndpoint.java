package com.quathar.codebay.infra.rest.api.crud;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Update Model Endpoint</h1>
 * <br/>
 * This interface defines an endpoint for updating a model.
 *
 * @param <Request>  The type of request object containing model new information.
 * @param <Response> The type of response object containing the updated model information.
 *
 * @since 2024-03-03
 * @version 1.0
 * @author Q
 */
public interface UpdateModelEndpoint<Request, Response> {

    /**
     * Updates an existing user by their unique identifier.
     *
     * @param id                The unique identifier of the model to be updated.
     * @param updateUserRequest The request object containing updated model information.
     * @return ResponseEntity containing the updated model information with appropriate status.
     */
    @PutMapping(value = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Response> update(
            @PathVariable
            UUID id,
            @RequestBody @Valid
            Request updateUserRequest,
            BindingResult bindingResult
    );

}
