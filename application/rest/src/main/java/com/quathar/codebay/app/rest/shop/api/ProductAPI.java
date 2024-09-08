package com.quathar.codebay.app.rest.shop.api;

import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.shop.model.request.BuyProductRequest;
import com.quathar.codebay.app.rest.shop.model.request.ShopProductParams;
import com.quathar.codebay.app.rest.shop.model.response.BasicOrderResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicProductResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Product API</h1>
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RequestMapping(ProductAPI.ROOT)
@PreAuthorize("hasRole('CUSTOMER')")
public interface ProductAPI {

    // <<-CONSTANT->>
    /**
     * The root path for product API.
     */
    String ROOT = BASE_URL + "/products";

    // <<-METHODS->>
    /**
     * Retrieves all products based on the provided search parameters.
     *
     * @param searchParams The parameters for searching products.
     * @return A {@link PageContentResponse} containing a list of {@link BasicProductResponse}.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("permitAll()")
    @ResponseStatus(OK)
    PageContentResponse<BasicProductResponse> getAll(@Valid ShopProductParams searchParams);

    /**
     * Retrieves a product by their code.
     *
     * @param code The unique code of the product.
     * @return {@link BasicProductResponse} containing the product information if found.
     */
    @GetMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("permitAll()")
    @ResponseStatus(OK)
    BasicProductResponse getByCode(@PathVariable String code);

    /**
     * Buys a specified quantity of a product.
     *
     * @param buyRequest The {@link BuyProductRequest} request body.
     * @return {@link BasicOrderResponse} containing the order information after purchase.
     */
    @PostMapping(path = "/buy", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('BUY_ONE_PRODUCT')")
    @ResponseStatus(OK)
    BasicOrderResponse buyOneProduct(@Valid @RequestBody BuyProductRequest buyRequest);

}
