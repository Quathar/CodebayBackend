package com.quathar.codebay.app.rest.management.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.api.CustomerManagementAPI;
import com.quathar.codebay.app.rest.management.model.factory.HttpManagementFactory;
import com.quathar.codebay.app.rest.management.model.user.response.FullCustomerResponse;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementCustomerResponse;
import com.quathar.codebay.app.service.user.CustomerService;
import com.quathar.codebay.domain.model.Customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Customer Management Controller</h1>
 *
 * @see CustomerManagementAPI
 * @since 2023-05-06
 * @version 1.0
 * @author Q
 */
@Slf4j
@RestController
@AllArgsConstructor
public class CustomerManagementController implements CustomerManagementAPI {

    // <<-FIELD->>
    /**
     * The customer service.
     */
    private final CustomerService customerService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<ManagementCustomerResponse> getAll(PageContentRequest pageContentRequest) {
        var pageIndex = pageContentRequest.page();
        var pageSize  = pageContentRequest.size();
        var response  = this.customerService
                .getAll(pageIndex, pageSize)
                .map(HttpManagementFactory.getManagementCustomerResponse()::fromModel)
                .toList();

        log.debug("Retrieving all management users with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public FullCustomerResponse getById(UUID id) {
        Customer customer = this.customerService.getById(id);

        log.debug("Retrieving management customer with ID: {}", id);

        return HttpManagementFactory
                .getFullCustomerResponse()
                .fromModel(customer);
    }

    @Override
    public ManagementCustomerResponse getByUsername(String username) {
        Customer customer = this.customerService.getByUsername(username);

        log.debug("Retrieving management customer with username: {}", username);

        return HttpManagementFactory
                .getManagementCustomerResponse()
                .fromModel(customer);
    }

}
