package com.quathar.codebay.infra.rest.management.api;

import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import jakarta.servlet.http.HttpServletRequest;
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

import static com.quathar.codebay.infra.rest.management.api.ManagementAPI.MANAGE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Administrator API</h1>
 * <br>
 * <p>
 *     This interface defines the endpoints related to admin operations.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(AdminAPI.ROOT)
public interface AdminAPI {

    /**
     * The root path for admin management API.
     */
    String ROOT = MANAGE_URL + "/admins";

    /**
     * Retrieves an admin by their unique ID.
     *
     * @param id The unique identifier of the admin.
     * @return ResponseEntity containing the admin information if found.
     * @throws com.quathar.codebay.domain.exception.ResourceNotFoundException if the identifier does not exist.
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> getById(@PathVariable UUID id);

    @GetMapping(value = "/profile", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> getProfile(HttpServletRequest request);

    /**
     * Creates a new admin.
     *
     * @param createUserRequest The request object containing admin information.
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
     * Updates an existing admin by their unique identifier.
     *
     * @param id                The unique identifier of the admin to be updated.
     * @param updateUserRequest The request object containing updated admin information.
     * @return ResponseEntity containing the updated admin information with appropriate status.
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
     * Deletes a admin by their unique ID.
     *
     * @param id The unique identifier of the admin to be deleted.
     * @return ResponseEntity with no body and appropriate status indicating success or failure of deletion.
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
