package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.in.DeleteModelUseCasePort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

/**
 * <h1>Delete Administrator by ID Use Case Implementation</h1>
 *
 * @see DeleteModelUseCasePort
 * @since 2024-04-28
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteAdminById implements DeleteModelUseCasePort<UUID> {

    // <<-CONSTANT->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-FIELD->>
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
    public void deleteById(UUID id) {
        this.adminRepositoryPort
                .findById(id)
                .ifPresent(this::deactivate);
    }

}
