package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.util.HashManager;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.enumerator.UserStatus;

import java.util.UUID;

/**
 * <h1>User Service</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class      UserService
       extends    CrudService<User, UUID>
       implements UserServicePort {

    // <<-FIELD->>
    private final UserRepositoryPort userRepositoryPort;

    // <<-CONSTRUCTOR->>
    public UserService(UserRepositoryPort userRepositoryPort) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
    }

    // <<-METHODS->>
    @Override
    public User create(User user) {
        String password = user.getPassword();
        user.setPassword(HashManager.hash(password));
        user.setStatus(UserStatus.ACTIVE);
        user.setSuccessfulAuth(0);
        user.setFailedAuth(0);
        return this.userRepositoryPort.save(user);
    }

}