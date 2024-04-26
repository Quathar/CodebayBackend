package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.DeleteByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Delete User by Username Use Case</h1>
 *
 * @see DeleteByUsernameUseCasePort
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteUserByUsernameUseCase implements DeleteByUsernameUseCasePort {

    // <<-CONSTANTS->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-FIELD->>
    /**
     * The user repository port.
     */
    @NonNull
    private final UserRepositoryPort userRepositoryPort;

    // <<-METHODS->>
    /**
     * Deactivates a user.
     *
     * @param user The user to deactivate
     */
    private void deactivate(User user) {
        user.setStatus(DISABLED_STATUS);
        this.userRepositoryPort.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        this.userRepositoryPort
                .findByUsername(username)
                .ifPresent(this::deactivate);
    }

}
