package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.in.user.UpdateByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Update Administrator by Username Use Case Implementation</h1>
 *
 * @see UpdateByUsernameUseCasePort
 * @see Administrator
 * @since 2024-05-05
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class UpdateAdminByUsernameUseCase implements UpdateByUsernameUseCasePort<Administrator> {

    // <<-FIELD->>
    /**
     * The customer repository port.
     */
    @NonNull
    private final AdministratorRepositoryPort adminRepositoryPort;

    // <<-METHOD->>
    @Override
    public Administrator updateByUsername(Administrator customerToUpdate) {
        // Created to avoid conflicts when running the app
        // TODO: Implement update logic here
        return customerToUpdate;
    }

}
