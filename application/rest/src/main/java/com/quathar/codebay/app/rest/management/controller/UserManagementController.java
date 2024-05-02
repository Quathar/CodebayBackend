package com.quathar.codebay.app.rest.management.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.management.api.UserManagementAPI;
import com.quathar.codebay.app.rest.management.model.factory.HttpManagementFactory;
import com.quathar.codebay.app.rest.management.model.user.request.CreateManagementUserRequest;
import com.quathar.codebay.app.rest.management.model.user.request.UpdateManagementUserRequest;
import com.quathar.codebay.app.rest.management.model.user.response.FullUserResponse;
import com.quathar.codebay.app.rest.management.model.user.response.ManagementUserResponse;
import com.quathar.codebay.app.service.user.UserService;
import com.quathar.codebay.domain.model.User;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>User Management Controller</h1>
 *
 * @see UserManagementAPI
 * @see UserService
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class UserManagementController implements UserManagementAPI {

    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    // <<-FIELD->>
    /**
     * The port for user service.
     */
    private final UserService userServicePort;

    // <<-METHODS->>
    @Override
    public PageContentResponse<ManagementUserResponse> getAll(PageContentRequest pageContentRequest) {
        var pageIndex = pageContentRequest.page();
        var pageSize  = pageContentRequest.size();
        var response  = this.userServicePort
                .getAll(pageIndex, pageSize)
                .map(HttpManagementFactory.getManagementUserResponse()::fromModel)
                .toList();

        log.debug("Retrieving all management users with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                response.size(),
                response
        );
    }

    @Override
    public FullUserResponse getById(UUID id) {
        User user = this.userServicePort.getById(id);

        log.debug("Retrieving management user with ID: {}", id);

        return HttpManagementFactory
                .getFullUserResponse()
                .fromModel(user);
    }

    @Override
    public ManagementUserResponse getByUsername(String username) {
        User user = this.userServicePort.getByUsername(username);

        log.debug("Retrieving management user with username: {}", username);

        return HttpManagementFactory
                .getManagementUserResponse()
                .fromModel(user);
    }

    @Override
    public ManagementUserResponse signup(CreateManagementUserRequest createRequest) {
        User userToRegister = HttpManagementFactory
                .setCreateManagementUserRequest()
                .toModel(createRequest);
        User createdUser = this.userServicePort.create(userToRegister);

        log.debug("Creating management user: {}", createRequest);

        return HttpManagementFactory
                .getManagementUserResponse()
                .fromModel(createdUser);
    }

    @Override
    public ManagementUserResponse update(UUID id, UpdateManagementUserRequest updateRequest) {
        User userToUpdate = HttpManagementFactory
                .setUpdateManagementUserRequest()
                .toModel(updateRequest);
        userToUpdate.setId(id);
        User updatedUser = this.userServicePort.update(userToUpdate);

        log.debug("Updating management user with ID {}: {}", id, updateRequest);

        return HttpManagementFactory
                .getManagementUserResponse()
                .fromModel(updatedUser);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting management user with ID: {}", id);
        this.userServicePort.deleteById(id);
    }

}
