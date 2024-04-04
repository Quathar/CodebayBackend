package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.application.inputport.AdministratorServicePort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.rest.api.AdminManagementAPI;
import com.quathar.codebay.infra.rest.common.factory.HttpCommonFactory;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.rest.factory.HttpManagementFactory;
import com.quathar.codebay.infra.rest.model.request.CreateAdminRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateAdminRequest;
import com.quathar.codebay.infra.rest.model.response.FullAdminResponse;
import com.quathar.codebay.infra.rest.model.response.ManagementAdminResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Administrator Controller</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RestController
public class AdminManagementController implements AdminManagementAPI {

    private static final Logger log = LoggerFactory.getLogger(AdminManagementController.class);

    // <<-FIELD->>
    /**
     * The port for admin service.
     */
    private final AdministratorServicePort adminServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code AdminController} with the specified {@code AdminServicePort}.
     *
     * @param adminServicePort The port for admin service.
     */
    @Autowired
    public AdminManagementController(AdministratorServicePort adminServicePort) {
        this.adminServicePort = adminServicePort;
    }

    // <<-METHODS->>
    @Override
    public PageContentResponse<FullAdminResponse> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        java.util.List<FullAdminResponse> response = this.adminServicePort
                .getAll(pageIndex, pageSize)
                .stream()
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
        String username = SecurityContextHolder
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
