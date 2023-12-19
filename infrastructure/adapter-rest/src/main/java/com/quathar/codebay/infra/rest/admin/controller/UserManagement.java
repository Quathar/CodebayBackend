package com.quathar.codebay.infra.rest.admin.controller;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.admin.api.UserManagementAPI;
import com.quathar.codebay.infra.rest.manager.MapperManager;
import com.quathar.codebay.infra.rest.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

 /**
 * <h1>User Management Controller</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@RestController
public class UserManagement implements UserManagementAPI {

    // <<-FIELD->>
    private final UserServicePort userServicePort;

    // <<-CONSTRUCTOR->>
    @Autowired
    public UserManagement(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    // <<-METHODS->>
    @Override
    public ResponseEntity<java.util.Set<User>> getAll() {
        // TODO: Implement this
        // TODO: Implement this
        // TODO: Implement this
        return null;
    }
    @Override
    public ResponseEntity<User> getById(UUID id) {
        User user = this.userServicePort.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<User> create(CreateUserRequest createUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        User user = MapperManager.getInstance(CreateUserRequestMapper.class).toModel(createUserRequest);
        User retrievedUser = this.userServicePort.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(retrievedUser);
    }

    @Override
    public ResponseEntity<User> update(UUID id, UpdateUserRequest updateUserRequest, BindingResult bindingResult) {
        // TODO: Complete
        // TODO: Complete
        // TODO: Complete
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.userServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
