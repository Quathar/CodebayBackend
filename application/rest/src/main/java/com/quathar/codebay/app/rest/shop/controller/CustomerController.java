package com.quathar.codebay.app.rest.shop.controller;

import com.quathar.codebay.app.rest.shop.api.CustomerAPI;
import com.quathar.codebay.app.rest.shop.model.factory.HttpShopFactory;
import com.quathar.codebay.app.rest.shop.model.request.CreateCustomerRequest;
import com.quathar.codebay.app.rest.shop.model.request.UpdateCustomerRequest;
import com.quathar.codebay.app.rest.shop.model.response.BasicCustomerResponse;
import com.quathar.codebay.app.service.user.CustomerService;
import com.quathar.codebay.domain.model.Customer;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Customer Controller</h1>
 *
 * @see CustomerAPI
 * @see CustomerService
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class CustomerController implements CustomerAPI {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    // <<-FIELDS->>
    /**
     * The customer service.
     */
    private final CustomerService customerService;

    // <<-METHOD->>
    @Override
    public BasicCustomerResponse signup(CreateCustomerRequest createRequest) {
        Customer customerToCreate = HttpShopFactory
                .setCreateCustomerRequest()
                .toModel(createRequest);
        Customer createdCustomer = this.customerService.create(customerToCreate);

        log.debug("Creating customer: {}", createRequest);

        return HttpShopFactory
                .getBasicCustomerResponse()
                .fromModel(createdCustomer);
    }

    @Override
    public BasicCustomerResponse update(String username, UpdateCustomerRequest updateRequest) {
        Customer customerToUpdate = HttpShopFactory
                .setUpdateCustomerRequest()
                .toModel(updateRequest);
        customerToUpdate.setUsername(username);
        Customer updatedCustomer = this.customerService.updateByUsername(customerToUpdate);

        log.debug("Updating customer with username {}: {}", username, updateRequest);

        return HttpShopFactory
                .getBasicCustomerResponse()
                .fromModel(updatedCustomer);
    }

}
