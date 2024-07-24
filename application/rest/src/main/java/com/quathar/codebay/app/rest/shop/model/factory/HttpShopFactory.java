package com.quathar.codebay.app.rest.shop.model.factory;

import com.quathar.codebay.app.rest.shop.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.UpdateUserRequestMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.request.CreateCustomerRequestMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.request.ShopProductParamsMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.request.UpdateCustomerRequestMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.response.BasicCartResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.response.BasicCustomerResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.response.BasicOrderResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.response.BasicProductResponseMapper;
import com.quathar.codebay.app.rest.shop.model.mapper.response.BasicWishListResponseMapper;

import static org.mapstruct.factory.Mappers.getMapper;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Shop Factory</h1>
 *
 * Manages and provides instances of different mappers.
 * <br>
 * This abstract class serves as a manager for various mapper instances.
 * It allows retrieval of specific mapper instances based on the provided Class.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpShopFactory {

    // ============
    // <<- USER ->>
    // ============
    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.User} domain model.
     *
     * @return An instance of {@link CreateUserRequestMapper}
     */
    static CreateUserRequestMapper setCreateUserRequest() {
        return getMapper(CreateUserRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.User} domain model.
     *
     * @return An instance of {@link UpdateUserRequestMapper}
     */
    static UpdateUserRequestMapper setUpdateUserRequest() {
        return getMapper(UpdateUserRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.User} domain model to the response.
     *
     * @return An instance of {@link BasicUserResponseMapper}
     */
    static BasicUserResponseMapper getBasicUserResponse() {
        return getMapper(BasicUserResponseMapper.class);
    }

    // ===============
    // <<- PRODUCT ->>
    // ===============
    /**
     * Returns a mapper to map the information from the parameters to the {@link com.quathar.codebay.domain.model.shop.ProductFilters} domain model.
     *
     * @return An instance of {@link ShopProductParamsMapper}
     */
    static ShopProductParamsMapper setShopProductParams() {
        return getMapper(ShopProductParamsMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.Product} domain model to the response.
     *
     * @return An instance of {@link BasicProductResponseMapper}
     */
    static BasicProductResponseMapper getBasicProductResponse() {
        return getMapper(BasicProductResponseMapper.class);
    }

    // ================
    // <<- CUSTOMER ->>
    // ================
    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.Customer} domain model.
     *
     * @return An instance of {@link CreateCustomerRequestMapper}
     */
    static CreateCustomerRequestMapper setCreateCustomerRequest() {
        return getMapper(CreateCustomerRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.Customer} domain model.
     *
     * @return An instance of {@link UpdateCustomerRequestMapper}
     */
    static UpdateCustomerRequestMapper setUpdateCustomerRequest() {
        return getMapper(UpdateCustomerRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.Customer} domain model to the response.
     *
     * @return An instance of {@link BasicCustomerResponseMapper}
     */
    static BasicCustomerResponseMapper getBasicCustomerResponse() {
        return getMapper(BasicCustomerResponseMapper.class);
    }

    // =====================
    // <<- SHOPPING CART ->>
    // =====================
    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.ShoppingCart} domain model to the response.
     *
     * @return An instance of {@link BasicCartResponseMapper}
     */
    static BasicCartResponseMapper getBasicShoppingCartResponse() {
        return getMapper(BasicCartResponseMapper.class);
    }

    // =================
    // <<- WISH LIST ->>
    // =================
    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.WishList} domain model to the response.
     *
     * @return An instance of {@link BasicWishListResponseMapper}
     */
    static BasicWishListResponseMapper getBasicWishListResponse() {
        return getMapper(BasicWishListResponseMapper.class);
    }

    // ==============
    // <<- ORDERS ->>
    // ==============
    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.Order} domain model to the response.
     *
     * @return An instance of {@link BasicOrderResponseMapper}
     */
    static BasicOrderResponseMapper getBasicOrderResponse() {
        return getMapper(BasicOrderResponseMapper.class);
    }

}
