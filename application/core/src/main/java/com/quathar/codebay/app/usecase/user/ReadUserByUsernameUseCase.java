package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.ReadByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read User by Username Use Case Implementation</h1>
 *
 * @see ReadByUsernameUseCasePort
 * @see User
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadUserByUsernameUseCase implements ReadByUsernameUseCasePort<User> {

    // <<-FIELD->>
    /**
     * The user repository port.
     */
    @NonNull
    private final UserRepositoryPort userRepositoryPort;

    // <<-METHOD->>
    @Override
    public User getByUsername(String username) {
        return this.userRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
    }

}
