package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.in.CreateModelUseCasePort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.domain.valueobject.Audit;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Create User Use Case Implementation</h1>
 *
 * @see CreateModelUseCasePort
 * @see User
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class CreateUserUseCase implements CreateModelUseCasePort<User> {

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
    private static final String BASIC_USER_ROLE = "USER";
    /**
     * Status indicating user is enabled.
     */
    private static final String ENABLED_STATUS = "ENABLED";

    // <<-FIELDS->>
    /**
     * The user repository port.
     */
    @NonNull
    private final UserRepositoryPort userRepositoryPort;
    /**
     * The role repository port.
     */
    @NonNull
    private final RoleRepositoryPort roleRepositoryPort;
    /**
     * The password service port.
     */
    @NonNull
    private final PasswordServicePort passwordServicePort;

    // <<-METHODS->>
    /**
     * Initializes a user by setting default values and performing necessary operations.
     *
     * @param userToRegister The user to initialize
     * @return The initialized user
     */
    private User initialize(User userToRegister) {
        var encodedPassword = this.passwordServicePort.encode( userToRegister.getPassword() );
        var role = this.roleRepositoryPort
                .findByName(BASIC_USER_ROLE)
                .get();
        var now = java.time.LocalDateTime.now();
        return User.builder()
                .username( userToRegister.getUsername() )
                .password( encodedPassword )
                .nickname( userToRegister.getNickname() )
                .email( userToRegister.getEmail() )
                .status( ENABLED_STATUS )
                .role( role )
                .successfulAuth( ZERO_AUTH_ATTEMPTS )
                .failedAuth( ZERO_AUTH_ATTEMPTS )
                .passwordExpirationDate( now.plusDays(EXPIRATION_DAYS) )
                .lastConnection( now )
                .audit( Audit.builder().creationDate(now).build() )
                .build();
    }

    @Override
    public User create(User userToRegister) {
        User initialized = this.initialize(userToRegister);
        return this.userRepositoryPort.save(initialized);
    }

}
