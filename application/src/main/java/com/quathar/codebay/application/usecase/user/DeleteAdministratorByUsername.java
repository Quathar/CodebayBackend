package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.outputport.AdministratorRepositoryPort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.user.DeleteByUsernameUseCase;

/**
 * <h1>Delete Administrator by Username Use Case Implementation</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public record DeleteAdministratorByUsername(AdministratorRepositoryPort adminRepositoryPort) implements DeleteByUsernameUseCase {

    // <<-CONSTANT->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

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
