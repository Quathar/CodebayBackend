package com.quathar.codebay.infra.inputadapter.http.controller;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.inputadapter.http.api.UserAPI;
import com.quathar.codebay.infra.inputadapter.http.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.infra.inputadapter.http.manager.MapperManager;
import com.quathar.codebay.infra.inputadapter.http.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.infra.inputadapter.http.model.mapper.UpdateUserRequestMapper;
import com.quathar.codebay.infra.inputadapter.http.model.request.CreateUserRequest;
import com.quathar.codebay.infra.inputadapter.http.model.request.UpdateUserRequest;
import com.quathar.codebay.infra.inputadapter.http.model.response.BasicUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>User Controller</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@RestController
public class UserController implements UserAPI {

    // <<-FIELD->>
    private final UserServicePort userServicePort;

    // <<-CONSTRUCTOR->>
    @Autowired
    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    // <<-METHODS->>
    @Override
    public ResponseEntity<BasicUserResponse> getById(UUID id) {
        User user = this.userServicePort.getById(id);
        BasicUserResponse basicUserInfo = MapperManager.getInstance(BasicUserResponseMapper.class).fromModel(user);
        return ResponseEntity.ok().body(basicUserInfo);
    }

    @Override
    public ResponseEntity<BasicUserResponse> create(CreateUserRequest createUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        User user = MapperManager.getInstance(CreateUserRequestMapper.class).toModel(createUserRequest);
        User retrievedUser = this.userServicePort.create(user);
        BasicUserResponse basicUserInfo = MapperManager.getInstance(BasicUserResponseMapper.class).fromModel(retrievedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(basicUserInfo);
    }

    @Override
    public ResponseEntity<BasicUserResponse> update(UUID id, UpdateUserRequest updateUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        User user = MapperManager.getInstance(UpdateUserRequestMapper.class).toModel(updateUserRequest);
        user.setId(id);
        User retrievedUser = this.userServicePort.update(user);
        BasicUserResponse basicUserInfo = MapperManager.getInstance(BasicUserResponseMapper.class).fromModel(retrievedUser);
        return ResponseEntity.ok().body(basicUserInfo);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.userServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
