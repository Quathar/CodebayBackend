package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.usecase.user.ReadByUsernameUseCase;

/**
 * <h1>Read User by Username Use Case Implementation</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record ReadUserByUsername(UserRepositoryPort repositoryPort) implements ReadByUsernameUseCase<User> {

    @Override
    public User getByUsername(String username) {
        return this.repositoryPort
                .findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
