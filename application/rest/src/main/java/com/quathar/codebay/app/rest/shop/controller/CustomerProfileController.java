package com.quathar.codebay.app.rest.shop.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.shop.api.CustomerProfileAPI;
import com.quathar.codebay.app.rest.shop.model.factory.HttpShopFactory;
import com.quathar.codebay.app.rest.shop.model.response.BasicCartResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicCustomerResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicOrderResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicWishListResponse;
import com.quathar.codebay.app.service.shop.OrderService;
import com.quathar.codebay.app.service.shop.ShoppingCartService;
import com.quathar.codebay.app.service.shop.WishListService;
import com.quathar.codebay.app.service.user.CustomerService;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.model.shop.WishList;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Customer Controller</h1>
 *
 * @see CustomerProfileAPI
 * @see CustomerService
 * @see ShoppingCartService
 * @see WishListService
 * @see OrderService
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class CustomerProfileController implements CustomerProfileAPI {

    private static final Logger log = LoggerFactory.getLogger(CustomerProfileController.class);

    // <<-FIELDS->>
    /**
     * The customer service.
     */
    private final CustomerService customerService;
    /**
     * The shopping cart service.
     */
    private final ShoppingCartService cartService;
    /**
     * The wish list service.
     */
    private final WishListService wishListService;
    /**
     * The order service.
     */
    private final OrderService orderService;

    // <<-METHODS->>
    /**
     * Retrieves the username of the authenticated customer.
     *
     * @return The username of the authenticated customer.
     */
    private String getAuthenticatedUsername() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal()
                .toString();
    }

    @Override
    public BasicCustomerResponse getProfile() {
        var username = this.getAuthenticatedUsername();
        Customer customer = this.customerService.getByUsername(username);

        log.debug("Retrieving customer through <<Authentication>> with username {}", username);

        return HttpShopFactory
                .getBasicCustomerResponse()
                .fromModel(customer);
    }

    @Override
    public BasicCartResponse getCartByUsername() {
        var username = this.getAuthenticatedUsername();
        ShoppingCart shoppingCart = this.cartService.getCartByUsername(username);

        log.debug("Retrieving customer {} shopping cart", username);

        return HttpShopFactory
                .getBasicShoppingCartResponse()
                .fromModel(shoppingCart);
    }

    @Override
    public BasicCartResponse addToCart(String productCode, Integer units) {
        var username = this.getAuthenticatedUsername();
        ShoppingCart updatedCart = this.cartService.addToCart(username, productCode, units);

        log.debug("Adding {} units of product {} to customer {} shopping cart", units, productCode, username);

        return HttpShopFactory
                .getBasicShoppingCartResponse()
                .fromModel(updatedCart);
    }

    @Override
    public BasicCartResponse updateCart(String productCode, Integer units) {
        var username = this.getAuthenticatedUsername();
        ShoppingCart updatedCart = this.cartService.updateInCart(username, productCode, units);

        log.debug("Updating {} units of product {} in customer {} shopping cart", units, productCode, username);

        return HttpShopFactory
                .getBasicShoppingCartResponse()
                .fromModel(updatedCart);
    }

    @Override
    public BasicCartResponse removeFromCart(String productCode) {
        var username = this.getAuthenticatedUsername();
        ShoppingCart updatedCart = this.cartService.removeFromCart(username, productCode);

        log.debug("Removing product {} from customer {} shopping cart", productCode, username);

        return HttpShopFactory
                .getBasicShoppingCartResponse()
                .fromModel(updatedCart);
    }

    @Override
    public BasicCartResponse fromCartToWishList(String productCode) {
        var username = this.getAuthenticatedUsername();
        ShoppingCart updatedCart = this.cartService.moveProductToWishList(username, productCode);

        log.debug("Moving product {} from shopping cart to wish list for customer {}", productCode, username);

        return HttpShopFactory
                .getBasicShoppingCartResponse()
                .fromModel(updatedCart);
    }

    @Override
    public BasicOrderResponse buyCart() {
        var username = this.getAuthenticatedUsername();
        Order createdOrder = this.cartService.buyCartProducts(username);

        log.debug("Buying customer {} shopping cart", username);

        return HttpShopFactory
                .getBasicOrderResponse()
                .fromModel(createdOrder);
    }

    @Override
    public BasicWishListResponse getWishListByUsername() {
        var username = this.getAuthenticatedUsername();
        WishList wishList = this.wishListService.getWishListByUsername(username);

        log.debug("Retrieving customer {} wish list", username);

        return HttpShopFactory
                .getBasicWishListResponse()
                .fromModel(wishList);
    }

    @Override
    public BasicWishListResponse addToWishList(String productCode) {
        var username = this.getAuthenticatedUsername();
        WishList updatedWishList = this.wishListService.addToWishList(username, productCode);

        log.debug("Adding product {} to customer {} wish list", productCode, username);

        return HttpShopFactory
                .getBasicWishListResponse()
                .fromModel(updatedWishList);
    }

    @Override
    public BasicWishListResponse removeFromWishList(String productCode) {
        var username = this.getAuthenticatedUsername();
        WishList updatedWishList = this.wishListService.removeFromWishList(username, productCode);

        log.debug("Removing product {} from customer {} wish list", productCode, username);

        return HttpShopFactory
                .getBasicWishListResponse()
                .fromModel(updatedWishList);
    }

    @Override
    public BasicWishListResponse fromWishListToCart(String productCode) {
        var username = this.getAuthenticatedUsername();
        WishList updatedWishList = this.wishListService.moveProductToCart(username, productCode);

        log.debug("Moving product {} from wish list to shopping cart for customer {}", productCode, username);

        return HttpShopFactory
                .getBasicWishListResponse()
                .fromModel(updatedWishList);
    }

    @Override
    public PageContentResponse<BasicOrderResponse> getOrders(PageContentRequest pageContentRequest) {
        var username  = this.getAuthenticatedUsername();
        var pageIndex = pageContentRequest.page();
        var pageSize  = pageContentRequest.size();
        var response  = this.orderService
                .getAllOrdersByUsername(username, pageIndex, pageSize)
                .map(HttpShopFactory.getBasicOrderResponse()::fromModel)
                .toList();

        log.debug("Retrieving all orders of customer {} with pageIndex {} and pageSize {}.", username, pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public BasicOrderResponse getOrderById(java.util.UUID orderId) {
        Order retrievedOrder = this.orderService.getById(orderId);

        log.debug("Retrieving order with ID {}", orderId);

        return HttpShopFactory
                .getBasicOrderResponse()
                .fromModel(retrievedOrder);
    }

}
