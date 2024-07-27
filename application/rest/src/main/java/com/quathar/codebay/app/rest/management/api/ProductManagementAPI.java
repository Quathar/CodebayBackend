package com.quathar.codebay.app.rest.management.api;

import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.model.product.request.ManagementProductParams;
import com.quathar.codebay.app.rest.management.model.product.response.FullProductResponse;
import com.quathar.codebay.app.rest.management.model.product.response.ManagementProductResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.quathar.codebay.app.rest.management.api.ManagementAPI.MANAGEMENT_URL;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Product Management API</h1>
 *
 * This interface defines the endpoints related to product management operations.
 *
 * @see ManagementAPI
 * @since 2023-05-11
 * @version 1.0
 * @author Q
 */
@RequestMapping(ProductManagementAPI.ROOT)
@PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT')")
public interface ProductManagementAPI {

    // <<-CONSTANT->>
    /**
     * The root path for product management API.
     */
    String ROOT = MANAGEMENT_URL + "/products";

    // <<-METHODS->>
    /**
     * Retrieves all products based on the provided search parameters.
     *
     * @param searchParams The parameters for searching products.
     * @return A {@link PageContentResponse} containing a list of {@link ManagementProductResponse}.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ALL_PRODUCTS')")
    @ResponseStatus(OK)
    PageContentResponse<ManagementProductResponse> getAll(@Valid ManagementProductParams searchParams);

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID in a {@link FullProductResponse}.
     *
     */
    @GetMapping(path = "/id/{id}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_PRODUCT_BY_ID')")
    @ResponseStatus(OK)
    FullProductResponse getById(@PathVariable UUID id);

    /**
     * Retrieves a product by its code.
     *
     * @param code The code of the product to retrieve.
     * @return The product with the specified code in a {@link ManagementProductResponse}.
     */
    @GetMapping(path = "/username/{code}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SYSADMIN', 'ADMIN', 'ASSISTANT')")
    @ResponseStatus(OK)
    ManagementProductResponse getByCode(@PathVariable String code);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_PRODUCT')")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable UUID id);

}
