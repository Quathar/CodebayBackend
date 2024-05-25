package com.quathar.codebay.app.rest.shop.api;

import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicCartResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicCustomerResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicOrderResponse;
import com.quathar.codebay.app.rest.shop.model.response.BasicWishListResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Customer Profile API</h1>
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RequestMapping(CustomerProfileAPI.ROOT)
@PreAuthorize("hasRole('CUSTOMER')")
public interface CustomerProfileAPI {

    // <<-CONSTANT->>
    /**
     * The root path for shopping cart API.
     */
    String ROOT = BASE_URL + "/customers/me";

    // <<-METHODS->>
    /**
     * Retrieves the profile of the authenticated customer.
     *
     * @return A {@link BasicCustomerResponse} containing the basic customer information.
     */
    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_MY_CUSTOMER_PROFILE')")
    @ResponseStatus(OK)
    BasicCustomerResponse getProfile();

    // [ SHOPPING CART ]
    /**
     * Retrieves the shopping cart of the authenticated customer by their username.
     *
     * @return A {@link BasicCartResponse} containing the basic cart information.
     */
    @GetMapping(path = "/cart", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_MY_CART')")
    @ResponseStatus(OK)
    BasicCartResponse getCartByUsername();

    /**
     * Adds a product to the authenticated customer's shopping cart.
     *
     * @param productCode The code of the product to add.
     * @param units       The number of units of the product to add.
     * @return A {@link BasicCartResponse} containing the updated cart information.
     */
    @PostMapping(path = "/cart/add/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADD_TO_MY_CART')")
    @ResponseStatus(OK)
    BasicCartResponse addToCart(@PathVariable String productCode, @RequestParam Integer units);

    /**
     * Updates the quantity of a product in the authenticated customer's shopping cart.
     *
     * @param productCode The code of the product to update.
     * @param units       The new number of units of the product.
     * @return A {@link BasicCartResponse} containing the updated cart information.
     */
    @PostMapping(path = "/cart/update/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADD_TO_MY_CART')")
    @ResponseStatus(OK)
    BasicCartResponse updateCart(@PathVariable String productCode, @RequestParam Integer units);

    /**
     * Removes a product from the authenticated customer's shopping cart.
     *
     * @param productCode The code of the product to remove.
     * @return A {@link BasicCartResponse} containing the updated cart information.
     */
    @DeleteMapping(path = "/cart/remove/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('REMOVE_FROM_MY_CART')")
    @ResponseStatus(OK)
    BasicCartResponse removeFromCart(@PathVariable String productCode);

    /**
     * Moves a product from the authenticated customer's shopping cart to their wish list.
     *
     * @param productCode The code of the product to move.
     * @return A {@link BasicCartResponse} containing the updated cart information.
     */
    @PostMapping(path = "/cart/move/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('MOVE_CART_TO_WISHLIST')")
    @ResponseStatus(OK)
    BasicCartResponse fromCartToWishList(@PathVariable String productCode);

    /**
     * Purchases the products in the authenticated customer's shopping cart.
     *
     * @return A {@link BasicOrderResponse} containing the order information for the purchased products.
     */
    @PostMapping(path = "/cart/buy", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('BUY_MY_CART_PRODUCTS')")
    @ResponseStatus(CREATED)
    BasicOrderResponse buyCart();

    // [ WISH LIST ]
    /**
     * Retrieves the wish list of the authenticated customer by their username.
     *
     * @return A {@link BasicWishListResponse} containing the basic wish list information.
     */
    @GetMapping(path = "/wish-list", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_MY_WISHLIST')")
    @ResponseStatus(OK)
    BasicWishListResponse getWishListByUsername();

    /**
     * Adds a product to the authenticated customer's wish list.
     *
     * @param productCode The code of the product to add.
     * @return A {@link BasicWishListResponse} containing the updated wish list information.
     */
    @PostMapping(path = "/wish-list/add/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADD_TO_MY_WISHLIST')")
    @ResponseStatus(OK)
    BasicWishListResponse addToWishList(@PathVariable String productCode);

    /**
     * Removes a product from the authenticated customer's wish list.
     *
     * @param productCode The code of the product to remove.
     * @return A {@link BasicWishListResponse} containing the updated wish list information.
     */
    @DeleteMapping(path = "/wish-list/remove/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('REMOVE_FROM_MY_WISHLIST')")
    @ResponseStatus(OK)
    BasicWishListResponse removeFromWishList(@PathVariable String productCode);

    /**
     * Moves a product from the authenticated customer's wish list to their shopping cart.
     *
     * @param productCode The code of the product to move.
     * @return A {@link BasicCartResponse} containing the updated cart information.
     */
    @PostMapping(path = "/wish-list/move/{productCode}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('MOVE_WISHLIST_TO_CART')")
    @ResponseStatus(OK)
    BasicCartResponse fromWishListToCart(@PathVariable String productCode);

    // [ ORDERS ]
    /**
     * Retrieves the orders of the authenticated customer.
     *
     * @param pageContentRequest The page params.
     * @return A {@link PageContentResponse} containing a list of orders.
     */
    @GetMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_MY_ORDERS')")
    @ResponseStatus(OK)
    PageContentResponse<BasicOrderResponse> getOrders(@Valid PageContentRequest pageContentRequest);

    /**
     * Retrieves a specific order by its ID for the authenticated customer.
     *
     * @param orderId The ID of the order to retrieve.
     * @return A {@link BasicOrderResponse} containing the order information if found.
     */
    @GetMapping(path = "/orders/{orderId}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('READ_ONE_ORDER')")
    @ResponseStatus(OK)
    BasicOrderResponse getOrderById(@PathVariable java.util.UUID orderId);

}
