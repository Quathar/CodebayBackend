package com.quathar.codebay.app.rest.management.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.api.ProductManagementAPI;
import com.quathar.codebay.app.rest.management.model.factory.HttpManagementFactory;
import com.quathar.codebay.app.rest.management.model.product.request.ManagementProductParams;
import com.quathar.codebay.app.rest.management.model.product.response.FullProductResponse;
import com.quathar.codebay.app.rest.management.model.product.response.ManagementProductResponse;
import com.quathar.codebay.app.service.shop.ProductService;
import com.quathar.codebay.domain.model.shop.Product;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Product Management Controller</h1>
 *
 * @see ProductManagementAPI
 * @since 2023-05-11
 * @version 1.0
 * @author Q
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ProductManagementController implements ProductManagementAPI {

    // <<-FIELD->>
    /**
     * The product service.
     */
    private final ProductService productService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<ManagementProductResponse> getAll(ManagementProductParams searchParams) {
        var pageIndex = searchParams.page();
        var filters   = HttpManagementFactory
                .setManagementProductParams()
                .toModel(searchParams);
        var response = this.productService
                .getAllFilteredWith(filters)
                .map(HttpManagementFactory.getManagementProductResponse()::fromModel)
                .toList();

        log.debug("Retrieving all products with filters {}", searchParams);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public FullProductResponse getById(UUID id) {
        Product product = this.productService.getById(id);

        log.debug("Retrieving management product with ID: {}", id);

        return HttpManagementFactory
                .getFullProductResponse()
                .fromModel(product);
    }

    @Override
    public ManagementProductResponse getByCode(String code) {
        Product product = this.productService.getByCode(code);

        log.debug("Retrieving management product with code: {}", code);

        return HttpManagementFactory
                .getManagementProductResponse()
                .fromModel(product);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting management product with ID: {}", id);
        this.productService.deleteById(id);
    }

}
