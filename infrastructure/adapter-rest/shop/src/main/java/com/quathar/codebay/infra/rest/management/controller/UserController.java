package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.api.UserAPI;
import com.quathar.codebay.infra.rest.factory.HttpShopFactory;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;
import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>User Controller</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@RestController
public class UserController implements UserAPI {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // <<-FIELD->>
    /**
     * The port for user service.
     */
    private final UserServicePort userServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code UserController} with the specified {@code UserServicePort}.
     *
     * @param userServicePort The port for user service.
     */
    @Autowired
    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    // <<-METHODS->>
    @Override
    public BasicUserResponse getByUsername(String username) {
        User user = this.userServicePort.getByUsername(username);

        log.debug("Retrieving user with username: {}", username);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(user);
    }

    @Override
    public BasicUserResponse getProfile() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .toString();
        User user = this.userServicePort.getByUsername(username);

        log.debug("Retrieving user through <<Authentication>> with username: {}", username);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(user);
    }

    @Override
    public BasicUserResponse signup(CreateUserRequest createRequest) {
        User user = HttpShopFactory
                .setCreateUserRequest()
                .toModel(createRequest);
        User retrievedUser = this.userServicePort.create(user);

        log.debug("Creating user: {}", createRequest);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(retrievedUser);
    }

    @Override
    public BasicUserResponse update(String username, UpdateUserRequest updateRequest) {
        User userToUpdate = HttpShopFactory
                .setUpdateUserResponse()
                .toModel(updateRequest);
        userToUpdate.setUsername(username);
        User updatedUser = this.userServicePort.update(userToUpdate);

        log.debug("Updating user with username {}: {}", username, updateRequest);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(updatedUser);
    }

    @Override
    public void delete(String username) {
        log.debug("Deleting user with username: {}", username);
        this.userServicePort.deleteByUsername(username);
    }

}
