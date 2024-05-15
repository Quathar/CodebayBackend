package com.quathar.codebay.app.rest.shop.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.shop.api.ProductAPI;
import com.quathar.codebay.app.rest.shop.model.factory.HttpShopFactory;
import com.quathar.codebay.app.rest.shop.model.request.ShopProductParams;
import com.quathar.codebay.app.rest.shop.model.response.BasicOrderResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicProductResponse;
import com.quathar.codebay.app.service.shop.ProductService;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.Product;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Product Controller</h1>
 *
 * @see ProductAPI
 * @see ProductService
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class ProductController implements ProductAPI {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    // <<-FIELDS->>
    /**
     * The product service.
     */
    private final ProductService productService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<BasicProductResponse> getAll(ShopProductParams searchParams) {
        var pageIndex = searchParams.page();
        var filters   = HttpShopFactory
                .setShopProductSearchParams()
                .toModel(searchParams);
        // This endpoint will show only products on sale
        // since it's invoked from the shop area
        filters.setOnSale(true);
        var response = this.productService
                .getAllFilteredWith(filters)
                .map(HttpShopFactory.getBasicProductResponse()::fromModel)
                .toList();

        log.debug("Retrieving all products with filters {}", searchParams);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public BasicProductResponse getByCode(String code) {
        Product product = this.productService.getByCode(code);

        log.debug("Retrieving product with code: {}", code);

        return HttpShopFactory
                .getBasicProductResponse()
                .fromModel(product);
    }

    @Override
    public BasicOrderResponse buyOneProduct(String code, Integer units) {
        var username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .toString();
        Order createdOrder = this.productService.buyProduct(username, code, units);

        log.debug("Buying {} units of product with code: {}", units, code);

        return HttpShopFactory
                .getBasicOrderResponse()
                .fromModel(createdOrder);
    }

}
