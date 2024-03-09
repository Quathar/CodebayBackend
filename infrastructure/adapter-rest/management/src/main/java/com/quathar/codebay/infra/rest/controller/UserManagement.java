package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.api.UserManagementAPI;
import com.quathar.codebay.infra.rest.manager.ManagementMapperManager;
import com.quathar.codebay.infra.rest.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;
import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;

import com.quathar.codebay.infra.rest.model.response.PageContentResponse;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<PageContentResponse<User>> getAll(PageContentRequest pageContentRequest) {
        java.util.List<User> users = this.userServicePort.getAll(
                pageContentRequest.pageIndex(),
                pageContentRequest.pageSize()
        );
        PageContentResponse<User> response = new PageContentResponse<>(
                pageContentRequest.pageIndex(),
                users.size(),
                users
        );
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<User> getById(UUID id) {
        User user = this.userServicePort.getById(id);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<BasicUserResponse> getProfile(HttpServletRequest request) {
        String token = request.getHeader("Authorization").split("\\s")[1];
        User user = this.userServicePort.getByToken(token);
        BasicUserResponse basicUserResponse = ManagementMapperManager.getInstance(BasicUserResponseMapper.class).fromModel(user);
        return ResponseEntity.ok().body(basicUserResponse);
    }

    @Override
    public ResponseEntity<User> create(CreateUserRequest createUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        User user = ManagementMapperManager.getInstance(CreateUserRequestMapper.class).toModel(createUserRequest);
        User retrievedUser = this.userServicePort.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(retrievedUser);
    }

    @Override
    public ResponseEntity<User> update(UUID id, UpdateUserRequest updateUserRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            System.err.println("hay errores obviamente");

        // TODO: Delete until the next comment
        System.out.println("pass through Update");
        System.out.println(updateUserRequest);
        User user = this.userServicePort.getById(id);
        user.setUsername(updateUserRequest.username());
        user.setNickname(updateUserRequest.nickname());
        user.setEmail(updateUserRequest.email());
        user.setStatus(updateUserRequest.status());
        User newUser = this.userServicePort.update(user);
        // Until here


        // TODO: Complete
        // TODO: Complete
        // TODO: Complete
        return ResponseEntity.ok().body(newUser);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.userServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
