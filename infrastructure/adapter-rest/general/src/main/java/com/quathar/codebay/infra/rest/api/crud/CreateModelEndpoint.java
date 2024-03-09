package com.quathar.codebay.infra.rest.api.crud;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Create Model Endpoint</h1>
 * <br/>
 * This interface defines an endpoint for creating a new model.
 *
 * @param <Request>  The type of request object containing model information.
 * @param <Response> The type of response object containing the newly created model information.
 *
 * @since 2024-03-03
 * @version 1.0
 * @author Q
 */
public interface CreateModelEndpoint<Request, Response> {

    /**
     * Creates a new model.
     *
     * @param requestBody   The request object containing model information.
     * @param bindingResult The result of validation binding.
     * @return ResponseEntity containing the newly created model information with appropriate status.
     */
    @PostMapping(value = "/create",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Response> create(
            @RequestBody @Valid
            Request requestBody,
            BindingResult bindingResult
    );

}
