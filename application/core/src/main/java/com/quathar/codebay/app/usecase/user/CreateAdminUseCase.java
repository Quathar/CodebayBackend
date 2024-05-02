package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.in.CreateModelUseCasePort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.domain.valueobject.Audit;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Create Administrator Use Case Implementation</h1>
 *
 * @see CreateModelUseCasePort
 * @see Administrator
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class CreateAdminUseCase implements CreateModelUseCasePort<Administrator> {

    // <<-CONSTANTS->>
    /**
     * Constant representing zero authentication attempts.
     */
    private static final int ZERO_AUTH_ATTEMPTS = 0;
    /**
     * Number of days until password expiration.
     */
    private static final int EXPIRATION_DAYS = 180;
    /**
     * Default role for new users.
     */
    private static final String BASIC_ADMIN_ROLE = "ASSISTANT";
    /**
     * Status indicating user is enabled.
     */
    private static final String ENABLED_STATUS = "ENABLED";

    // <<-FIELD->>
    /**
     * The administrator repository port.
     */
    @NonNull
    private final AdministratorRepositoryPort adminRepositoryPort;
    /**
     * The administrator repository port.
     */
    @NonNull
    private final RoleRepositoryPort roleRepositoryPort;
    /**
     * The administrator repository port.
     */
    @NonNull
    private final PasswordServicePort passwordServicePort;

    // <<-METHODS->>
    /**
     * Initializes an admin by setting default values and performing necessary operations.
     *
     * @param adminToRegister The admin to initialize
     * @return The initialized user
     */
    private Administrator initialize(Administrator adminToRegister) {
        var encodedPassword = this.passwordServicePort.encode( adminToRegister.getPassword() );
        var role = this.roleRepositoryPort
                .findByName(BASIC_ADMIN_ROLE)
                .get();
        var now = java.time.LocalDateTime.now();
        return Administrator.builder()
                .username( adminToRegister.getUsername() )
                .password( encodedPassword )
                .nickname( adminToRegister.getNickname() )
                .email( adminToRegister.getEmail() )
                .status( ENABLED_STATUS )
                .role( role )
                .successfulAuth( ZERO_AUTH_ATTEMPTS )
                .failedAuth( ZERO_AUTH_ATTEMPTS )
                .passwordExpirationDate( now.plusDays(EXPIRATION_DAYS) )
                .lastConnection( now )
                .audit( Audit.builder().creationDate(now).build() )
                .personalInfo( adminToRegister.getPersonalInfo() )
                .build();
    }

    @Override
    public Administrator create(Administrator adminToRegister) {
        Administrator initialized = this.initialize(adminToRegister);
        return this.adminRepositoryPort.save(initialized);
    }

}
