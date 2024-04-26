package com.quathar.codebay.app.rest.management.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.api.AdminManagementAPI;
import com.quathar.codebay.app.rest.management.model.factory.HttpManagementFactory;
import com.quathar.codebay.app.rest.management.model.user.request.CreateAdminRequest;
import com.quathar.codebay.app.rest.management.model.user.request.UpdateAdminRequest;
import com.quathar.codebay.app.rest.management.model.user.response.FullAdminResponse;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementAdminResponse;
import com.quathar.codebay.app.service.user.AdministratorService;
import com.quathar.codebay.domain.model.Administrator;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Administrator Controller</h1>
 *
 * @see AdminManagementAPI
 * @see AdministratorService
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class AdminManagementController implements AdminManagementAPI {

    private static final Logger log = LoggerFactory.getLogger(AdminManagementController.class);

    // <<-FIELD->>
    /**
     * The port for admin service.
     */
    private final AdministratorService adminServicePort;

    // <<-METHODS->>
    @Override
    public PageContentResponse<FullAdminResponse> getAll(PageContentRequest pageContentRequest) {
        var pageIndex = pageContentRequest.page();
        var pageSize  = pageContentRequest.size();
        var response  = this.adminServicePort
                .getAll(pageIndex, pageSize)
                .map(HttpManagementFactory.getFullAdminResponse()::fromModel)
                .toList();

        log.debug("Retrieving all administrators with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public FullAdminResponse getById(UUID id) {
        Administrator admin = this.adminServicePort.getById(id);

        log.debug("Retrieving administrator with ID: {}", id);

        return HttpManagementFactory
                .getFullAdminResponse()
                .fromModel(admin);
    }

    @Override
    public ManagementAdminResponse getByUsername(String username) {
        Administrator admin = this.adminServicePort.getByUsername(username);

        log.debug("Retrieving administrator with username: {}", username);

        return HttpManagementFactory
                .getManagementAdminResponse()
                .fromModel(admin);
    }

    @Override
    public FullAdminResponse getProfile() {
        var username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .toString();
        Administrator admin = this.adminServicePort.getByUsername(username);

        log.debug("Retrieving administrator through <<Authentication>> with username: {}", username);

        return HttpManagementFactory
                .getFullAdminResponse()
                .fromModel(admin);
    }

    @Override
    public ManagementAdminResponse signup(CreateAdminRequest createRequest) {
        Administrator adminToRegister = HttpManagementFactory
                .setCreateAdminRequest()
                .toModel(createRequest);
        Administrator createdAdmin = this.adminServicePort.create(adminToRegister);

        log.debug("Creating administrator: {}", createRequest);

        return HttpManagementFactory
                .getManagementAdminResponse()
                .fromModel(createdAdmin);
    }

    @Override
    public ManagementAdminResponse update(UUID id, UpdateAdminRequest updateRequest) {
        Administrator adminToUpdate = HttpManagementFactory
                .setUpdateAdminRequest()
                .toModel(updateRequest);
        adminToUpdate.setId(id);
        Administrator updatedAdmin = this.adminServicePort.update(adminToUpdate);

        log.debug("Updating administrator with ID {}: {}", id, updateRequest);

        return HttpManagementFactory
                .getManagementAdminResponse()
                .fromModel(updatedAdmin);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting administrator with ID: {}", id);
        this.adminServicePort.deleteById(id);
    }

}
