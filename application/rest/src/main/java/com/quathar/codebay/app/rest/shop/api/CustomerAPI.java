package com.quathar.codebay.app.rest.shop.api;

import com.quathar.codebay.app.rest.shop.model.request.CreateCustomerRequest;
import com.quathar.codebay.app.rest.shop.model.request.UpdateCustomerRequest;
import com.quathar.codebay.app.rest.shop.model.response.BasicCustomerResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Customer API</h1>
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RequestMapping(CustomerAPI.ROOT)
@PreAuthorize("hasRole('CUSTOMER')")
public interface CustomerAPI {

    // <<-CONSTANT->>
    /**
     * The root path for customer API.
     */
    String ROOT = BASE_URL + "/customers";

    // <<-METHODS->>
    /**
     * Registers a new customer.
     *
     * @param createRequest The request body containing the information of the customer to be registered.
     * @return {@link BasicCustomerResponse} containing the registered customer information.
     */
    @PostMapping(path = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') AND #createRequest.username == authentication.principal")
    @ResponseStatus(CREATED)
    BasicCustomerResponse signup(@Valid @RequestBody CreateCustomerRequest createRequest);

    /**
     * Updates an existing customer by their username.
     *
     * @param username      The username of the customer to be updated.
     * @param updateRequest The request object containing updated customer information.
     * @return {@link BasicCustomerResponse} containing the updated user information.
     */
    @PutMapping(path = "/{username}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('UPDATE_MY_CUSTOMER_PROFILE') AND #username == authentication.principal")
    @ResponseStatus(OK)
    BasicCustomerResponse update(
            @PathVariable String username,
            @Valid @RequestBody
            UpdateCustomerRequest updateRequest
    );

}
