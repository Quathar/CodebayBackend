package com.quathar.codebay.app.rest.management.model.factory;

import com.quathar.codebay.app.rest.management.model.product.response.mapper.FullProductResponseMapper;
import com.quathar.codebay.app.rest.management.model.product.request.mapper.ManagementProductParamsMapper;
import com.quathar.codebay.app.rest.management.model.product.response.mapper.ManagementProductResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.CreateAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.CreateManagementUserRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.UpdateAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.request.UpdateManagementUserRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.FullAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.FullCustomerResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.FullUserResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.ManagementAdminResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.ManagementCustomerResponseMapper;
import com.quathar.codebay.app.rest.management.model.user.mapper.response.ManagementUserResponseMapper;

import static org.mapstruct.factory.Mappers.getMapper;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Management Factory</h1>
 *
 * Manages and provides instances of different mappers.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpManagementFactory {

    // ============
    // <<- USER ->>
    // ============
    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.User} domain model.
     *
     * @return An instance of {@link CreateManagementUserRequestMapper}
     */
    static CreateManagementUserRequestMapper setCreateManagementUserRequest() {
        return getMapper(CreateManagementUserRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.User} domain model.
     *
     * @return An instance of {@link UpdateManagementUserRequestMapper}
     */
    static UpdateManagementUserRequestMapper setUpdateManagementUserRequest() {
        return getMapper(UpdateManagementUserRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.User} domain model to the response.
     *
     * @return An instance of {@link FullUserResponseMapper}
     */
    static FullUserResponseMapper getFullUserResponse() {
        return getMapper(FullUserResponseMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.User} domain model to the response.
     *
     * @return An instance of {@link ManagementUserResponseMapper}
     */
    static ManagementUserResponseMapper getManagementUserResponse() {
        return getMapper(ManagementUserResponseMapper.class);
    }

    // =============
    // <<- ADMIN ->>
    // =============
    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.Administrator} domain model.
     *
     * @return An instance of {@link CreateAdminRequestMapper}
     */
    static CreateAdminRequestMapper setCreateAdminRequest() {
        return getMapper(CreateAdminRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the request to the {@link com.quathar.codebay.domain.model.Administrator} domain model.
     *
     * @return An instance of {@link UpdateAdminRequestMapper}
     */
    static UpdateAdminRequestMapper setUpdateAdminRequest() {
        return getMapper(UpdateAdminRequestMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.Administrator} domain model to the response.
     *
     * @return An instance of {@link FullAdminResponseMapper}
     */
    static FullAdminResponseMapper getFullAdminResponse() {
        return getMapper(FullAdminResponseMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.Administrator} domain model to the response.
     *
     * @return An instance of {@link ManagementAdminResponseMapper}
     */
    static ManagementAdminResponseMapper getManagementAdminResponse() {
        return getMapper(ManagementAdminResponseMapper.class);
    }

    // ================
    // <<- CUSTOMER ->>
    // ================
    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.Administrator} domain model to the response.
     *
     * @return An instance of {@link FullCustomerResponseMapper}
     */
    static FullCustomerResponseMapper getFullCustomerResponse() {
        return getMapper(FullCustomerResponseMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.Administrator} domain model to the response.
     *
     * @return An instance of {@link ManagementCustomerResponseMapper}
     */
    static ManagementCustomerResponseMapper getManagementCustomerResponse() {
        return getMapper(ManagementCustomerResponseMapper.class);
    }

    // ===============
    // <<- PRODUCT ->>
    // ===============
    /**
     * Returns a mapper to map the information from the request params to the {@link com.quathar.codebay.domain.model.shop.ProductFilters} domain model.
     *
     * @return An instance of {@link ManagementProductParamsMapper}
     */
    static ManagementProductParamsMapper setManagementProductParams() {
        return getMapper(ManagementProductParamsMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.Product} domain model to the response.
     *
     * @return An instance of {@link FullProductResponseMapper}
     */
    static FullProductResponseMapper getFullProductResponse() {
        return getMapper(FullProductResponseMapper.class);
    }

    /**
     * Returns a mapper to map the information from the {@link com.quathar.codebay.domain.model.shop.Product} domain model to the response.
     *
     * @return An instance of {@link ManagementProductResponseMapper}
     */
    static ManagementProductResponseMapper getManagementProductResponse() {
        return getMapper(ManagementProductResponseMapper.class);
    }

}
