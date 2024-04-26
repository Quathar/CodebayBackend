package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.in.user.DeleteByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Delete Administrator by Username Use Case Implementation</h1>
 *
 * @see DeleteByUsernameUseCasePort
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteAdminByUsernameUseCase implements DeleteByUsernameUseCasePort {

    // <<-CONSTANT->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-CONSTANT->>
    /**
     * The administrator repository port.
     */
    @NonNull
    private final AdministratorRepositoryPort adminRepositoryPort;

    // <<-METHODS->>
    /**
     * Deactivates an admin.
     *
     * @param admin The admin to deactivate
     */
    private void deactivate(Administrator admin) {
        admin.setStatus(DISABLED_STATUS);
        this.adminRepositoryPort.save(admin);
    }

    @Override
    public void deleteByUsername(String username) {
        this.adminRepositoryPort
                .findByUsername(username)
                .ifPresent(this::deactivate);
    }

}
