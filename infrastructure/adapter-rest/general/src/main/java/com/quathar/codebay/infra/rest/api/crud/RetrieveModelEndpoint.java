package com.quathar.codebay.infra.rest.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface RetrieveModelEndpoint<Response> {

    /**
     * Retrieves a model by their unique ID.
     *
     * @param id The unique identifier of the model.
     * @return ResponseEntity containing the model information if found.
     * @throws com.quathar.codebay.domain.exception.ResourceNotFoundException if the identifier does not exist.
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Response> getById(@PathVariable UUID id);

}
