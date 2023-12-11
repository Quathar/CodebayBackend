package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.UserUseCase;
import com.quathar.codebay.domain.model.User;

import java.util.UUID;

/**
 * <h1>User Service</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class UserService implements UserUseCase {

    // <<-FIELD->>
    private final UserUseCase userUseCase;

    // <<-CONSTRUCTOR->>
    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    // <<-METHODS->>
    @Override
    public User create(User model) {
        return userUseCase.create(model);
    }

    @Override
    public User getById(UUID uuid) {
        return userUseCase.getById(uuid);
    }

    @Override
    public User update(User model) {
        return userUseCase.update(model);
    }

    @Override
    public boolean deleteById(UUID uuid) {
        return userUseCase.deleteById(uuid);
    }

}
