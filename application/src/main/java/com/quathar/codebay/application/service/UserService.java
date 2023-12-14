package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.model.User;

import java.util.UUID;

/**
 * <h1>User Service</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class UserService extends CrudService<User, UUID> implements UserServicePort {

    // <<-FIELD->>
    private final UserRepositoryPort userRepositoryPort;

    // <<-CONSTRUCTOR->>
    public UserService(UserRepositoryPort userRepositoryPort) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
    }

}