package com.quathar.codebay.infra.rest.api.crud;

import com.quathar.codebay.infra.rest.model.request.PageContentRequest;

import com.quathar.codebay.infra.rest.model.response.PageContentResponse;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface RetrieveAllModelsEndpoint<Response> {

    /**
     * Retrieves all content based on the provided PageContentRequest parameters.
     *
     * @param pageContentRequest The ContentRequest containing parameters for content retrieval.
     * @return A ResponseEntity containing the retrieved content or an error response.
     */
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<PageContentResponse<Response>> getAll(@Valid PageContentRequest pageContentRequest);

}
