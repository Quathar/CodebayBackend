package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.util.PasswordHasher;
import com.quathar.codebay.domain.exception.InvalidCredentialsException;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.enumerator.UserStatus;

import java.time.LocalDateTime;
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

    // <<-METHODS->>
    @Override
    public User create(User user) {
        String password = user.getPassword();
        user.setPassword(PasswordHasher.hash(password));
        user.setStatus(UserStatus.ACTIVE);
        user.setSuccessfulAuth(0);
        user.setFailedAuth(0);
        return this.userRepositoryPort.save(user);
    }

    @Override
    public String login(String username, String password) {
        User user = this.userRepositoryPort.findByUsername(username).orElseThrow(InvalidCredentialsException::new);

        if (!PasswordHasher.matches(password, user.getPassword())) {
            Integer failedAuth = user.getFailedAuth();
            user.setFailedAuth(++failedAuth);
            throw new InvalidCredentialsException();
        }

        Integer successfulAuth = user.getSuccessfulAuth();
        user.setSuccessfulAuth(++successfulAuth);
        user.setLastConnection(LocalDateTime.now());

        // TODO: finish auth
        // Generate token
        // Save token in the repository
        return "token";
    }

}