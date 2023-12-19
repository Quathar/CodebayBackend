package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.BaseAPI.BASE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User API</h1>
 * <br>
 * <p>
 *     This interface defines the endpoints related to user operations.
 * </p>
 *
 * @since 2023-12-12
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserAPI.ROOT)
public interface UserAPI {

    /**
     * The root path for user management API.
     */
    String ROOT = BASE_URL + "/users";

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The unique identifier of the user.
     * @return ResponseEntity containing the user information if found.
     * @throws com.quathar.codebay.domain.exception.ResourceNotFoundException if the identifier does not exist.
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> getById(@PathVariable UUID id);

    /**
     * Creates a new user.
     *
     * @param createUserRequest The request object containing user information.
     * @param bindingResult     The result of validation binding.
     * @return ResponseEntity containing the newly created user information with appropriate status.
     */
    @PostMapping(value = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> create(
            @RequestBody @Valid
            CreateUserRequest createUserRequest,
            BindingResult bindingResult
    );

    /**
     * Updates an existing user by their unique identifier.
     *
     * @param id                The unique identifier of the user to be updated.
     * @param updateUserRequest The request object containing updated user information.
     * @return ResponseEntity containing the updated user information with appropriate status.
     */
    @PutMapping(value = "/{id}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> update(
            @PathVariable
            UUID id,
            @RequestBody @Valid
            UpdateUserRequest updateUserRequest,
            BindingResult bindingResult
    );

    /**
     * Deletes a user by their unique ID.
     *
     * @param id The unique identifier of the user to be deleted.
     * @return ResponseEntity with no body and appropriate status indicating success or failure of deletion.
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
