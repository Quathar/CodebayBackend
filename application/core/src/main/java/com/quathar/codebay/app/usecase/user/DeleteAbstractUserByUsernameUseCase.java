package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.DeleteByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.AbstractUserRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Delete abstract user by username Use Case Implementation</h1>
 *
 * @param <M> The type of abstract user
 *
 * @see DeleteByUsernameUseCasePort
 * @see User
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteAbstractUserByUsernameUseCase<M extends User> implements DeleteByUsernameUseCasePort {

    // <<-CONSTANT->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-FIELD->>
    /**
     * The abstract repository port.
     */
    @NonNull
    private final AbstractUserRepositoryPort<M, ?> abstractUserRepositoryPort;

    // <<-METHODS->>
    /**
     * Deactivates a user.
     *
     * @param admin The user to deactivate
     */
    private void deactivate(M admin) {
        admin.setStatus(DISABLED_STATUS);
        this.abstractUserRepositoryPort.save(admin);
    }

    @Override
    public void deleteByUsername(String username) {
        this.abstractUserRepositoryPort
                .findByUsername(username)
                .ifPresent(this::deactivate);
    }

}
