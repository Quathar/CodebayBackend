package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.DeleteModelUseCasePort;
import com.quathar.codebay.domain.port.out.user.AbstractUserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

/**
 * <h1>Delete abstract user by ID Use Case Implementation</h1>
 *
 * @param <M> The type of abstract user
 *
 * @see DeleteModelUseCasePort
 * @see User
 * @since 2024-04-28
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class DeleteAbstractUserByIdUseCase<M extends User> implements DeleteModelUseCasePort<UUID> {

    // <<-CONSTANT->>
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-FIELD->>
    /**
     * The abstract user repository port.
     */
    @NonNull
    private final AbstractUserRepositoryPort<M, UUID> abstractUserRepositoryPort;

    // <<-METHODS->>
    /**
     * Deactivates a user.
     *
     * @param user The user to deactivate
     */
    private void deactivate(M user) {
        user.setStatus(DISABLED_STATUS);
        this.abstractUserRepositoryPort.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        this.abstractUserRepositoryPort
                .findById(id)
                .ifPresent(this::deactivate);
    }

}
