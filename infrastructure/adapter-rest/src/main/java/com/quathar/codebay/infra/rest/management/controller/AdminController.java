package com.quathar.codebay.infra.rest.management.controller;

import com.quathar.codebay.application.inputport.AdminServicePort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.rest.management.api.AdminAPI;
import com.quathar.codebay.infra.rest.manager.MapperManager;
import com.quathar.codebay.infra.rest.model.mapper.BasicAdminResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.CreateAdminRequestMapper;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;

import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Admin Controller</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RestController
public class AdminController implements AdminAPI {

    // <<-FIELD->>
    private final AdminServicePort adminServicePort;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AdminController(AdminServicePort adminServicePort) {
        this.adminServicePort = adminServicePort;
    }

    // <<-METHODS->>
    @Override
    public ResponseEntity<Administrator> getById(UUID id) {
        Administrator admin = this.adminServicePort.getById(id);
        return ResponseEntity.ok().body(admin);
    }

    @Override
    public ResponseEntity<BasicUserResponse> getProfile(HttpServletRequest request) {
        String token = request.getHeader("Authorization").split("\\s")[1];
        Administrator admin = this.adminServicePort.getByToken(token);
        BasicUserResponse basicUserResponse = MapperManager.getInstance(BasicAdminResponseMapper.class).fromModel(admin);
        return ResponseEntity.ok().body(basicUserResponse);
    }

    @Override
    public ResponseEntity<Administrator> create(CreateUserRequest createUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        Administrator user = MapperManager.getInstance(CreateAdminRequestMapper.class).toModel(createUserRequest);
        Administrator retrievedUser = this.adminServicePort.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(retrievedUser);
    }

    @Override
    public ResponseEntity<?> update(UUID id, UpdateUserRequest updateUserRequest, BindingResult bindingResult) {
        // TODO: Implement
        // TODO: Implement
        // TODO: Implement
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.adminServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
