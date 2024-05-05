package com.quathar.codebay.app.rest.shop.controller;

import com.quathar.codebay.app.rest.shop.api.UserAPI;
import com.quathar.codebay.app.rest.shop.model.factory.HttpShopFactory;
import com.quathar.codebay.app.rest.shop.model.request.CreateUserRequest;
import com.quathar.codebay.app.rest.shop.model.request.UpdateUserRequest;
import com.quathar.codebay.app.rest.shop.model.response.BasicUserResponse;
import com.quathar.codebay.app.service.user.UserService;
import com.quathar.codebay.domain.model.User;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@AllArgsConstructor
public class UserController implements UserAPI {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // <<-FIELD->>
    /**
     * The port for user service.
     */
    private final UserService userService;

    // <<-METHODS->>
    @Override
    public BasicUserResponse getByUsername(String username) {
        User user = this.userService.getByUsername(username);

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
        User user = this.userService.getByUsername(username);

        log.debug("Retrieving user through <<Authentication>> with username: {}", username);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(user);
    }

    @Override
    public BasicUserResponse signup(CreateUserRequest createRequest) {
        User userToCreate = HttpShopFactory
                .setCreateUserRequest()
                .toModel(createRequest);
        User createdUser = this.userService.create(userToCreate);

        log.debug("Creating user: {}", createRequest);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(createdUser);
    }

    @Override
    public BasicUserResponse update(String username, UpdateUserRequest updateRequest) {
        User userToUpdate = HttpShopFactory
                .setUpdateUserResponse()
                .toModel(updateRequest);
        userToUpdate.setUsername(username);
        User updatedUser = this.userService.updateByUsername(userToUpdate);

        log.debug("Updating user with username {}: {}", username, updateRequest);

        return HttpShopFactory
                .getBasicUserResponse()
                .fromModel(updatedUser);
    }

    @Override
    public void delete(String username) {
        log.debug("Deleting user with username: {}", username);
        this.userService.deleteByUsername(username);
    }

}
