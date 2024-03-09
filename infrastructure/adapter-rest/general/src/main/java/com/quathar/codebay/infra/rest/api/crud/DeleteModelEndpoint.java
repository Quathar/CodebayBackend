package com.quathar.codebay.infra.rest.api.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface DeleteModelEndpoint {

    /**
     * Deletes a model by their unique ID.
     *
     * @param id The unique identifier of the model to be deleted.
     * @return ResponseEntity with no body and appropriate status indicating success or failure of deletion.
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
