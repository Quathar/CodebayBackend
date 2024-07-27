package com.quathar.codebay.app.rest.management.api;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.model.product.response.ManagementProductResponse;
import com.quathar.codebay.app.rest.management.model.user.response.FullCustomerResponse;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementCustomerResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.app.rest.management.api.ManagementAPI.MANAGEMENT_URL;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Customer Management API</h1>
 *
 * This interface defines the endpoints related to customer management operations.
 *
 * @see ManagementAPI
 * @since 2023-05-06
 * @version 1.0
 * @author Q
 */
@RequestMapping(CustomerManagementAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT')")
public interface CustomerManagementAPI {

    // <<-CONSTANT->>
    /**
     * The root path for customer management API.
     */
    String ROOT = MANAGEMENT_URL + "/customers";

    // <<-METHODS->>
    /**
     * Retrieves a page of customers.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of {@link ManagementCustomerResponse}.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_CUSTOMERS')")
    @ResponseStatus(OK)
    PageContentResponse<ManagementCustomerResponse> getAll(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a customer by its ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return The customer with the specified ID in a {@link FullCustomerResponse}.
     *
     */
    @GetMapping(path = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_CUSTOMER_BY_ID')")
    @ResponseStatus(OK)
    FullCustomerResponse getById(@PathVariable UUID id);

    /**
     * Retrieves a customer by its username.
     *
     * @param username The username of the customer to retrieve.
     * @return The customer with the specified username in a {@link ManagementCustomerResponse}.
     */
    @GetMapping(path = "/username/{username}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_CUSTOMER_BY_USERNAME')")
    @ResponseStatus(OK)
    ManagementCustomerResponse getByUsername(@PathVariable String username);

}
