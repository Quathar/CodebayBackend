package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.UpdateByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

/**
 * <h1>Update User by Username Use Case Implementation</h1>
 *
 * @see UpdateByUsernameUseCasePort
 * @see User
 * @since 2024-05-05
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class UpdateUserByUsernameUseCase implements UpdateByUsernameUseCasePort<User> {

    // <<-FIELD->>
    /**
     * The user repository port.
     */
    @NonNull
    private final UserRepositoryPort userRepositoryPort;

    // <<-METHOD->>
    @Override
    public User updateByUsername(User userToUpdate) {
        User userStored = this.userRepositoryPort
                .findByUsername(userToUpdate.getUsername())
                .orElseThrow(ModelNotFoundException::new);

        Optional.ofNullable(userToUpdate.getUsername())
                .ifPresent(userStored::setUsername);
        Optional.ofNullable(userToUpdate.getPassword())
                .ifPresent(userStored::setPassword);
        Optional.ofNullable(userToUpdate.getNickname())
                .ifPresent(userStored::setNickname);
        Optional.ofNullable(userToUpdate.getEmail())
                .ifPresent(userStored::setEmail);

        return this.userRepositoryPort.update(userStored);
    }

}
