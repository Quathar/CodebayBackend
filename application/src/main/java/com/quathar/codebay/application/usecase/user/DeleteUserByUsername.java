package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.usecase.user.DeleteByUsernameUseCase;

/**
 * <h1>Delete User by Username Use Case</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record DeleteUserByUsername(UserRepositoryPort userRepositoryPort) implements DeleteByUsernameUseCase {

    // <<-CONSTANTS->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

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
