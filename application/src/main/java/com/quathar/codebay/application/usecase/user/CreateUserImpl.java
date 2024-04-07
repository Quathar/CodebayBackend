package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.inputport.security.PasswordServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;

/**
 * <h1>Create User Use Case Implementation</h1>
 *
 * @param userRepositoryPort  The user repository port for managing users
 * @param roleRepositoryPort  The role repository port for managing roles
 * @param passwordServicePort The password encoder port for encoding passwords
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public record CreateUserImpl(
        UserRepositoryPort  userRepositoryPort,
        RoleRepositoryPort  roleRepositoryPort,
        PasswordServicePort passwordServicePort
) implements CreateModelUseCase<User> {

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

    // <<-METHODS->>
    /**
     * Encodes the raw password using the password encoder.
     *
     * @param rawPassword The raw password to encode
     * @return The encoded password
     */
    private String encode(String rawPassword) {
        return this.passwordServicePort.encode(rawPassword);
    }

    /**
     * Fetches a role by its name.
     *
     * @param roleName The name of the role to fetch
     * @return The role with the specified name
     */
    private Role fetchRole(String roleName) {
        return this.roleRepositoryPort
                .findByName(roleName)
                .get();
    }

    /**
     * Initializes a user by setting default values and performing necessary operations.
     *
     * @param userToRegister The user to initialize
     * @return The initialized user
     */
    private User initialize(User userToRegister) {
        var now = java.time.LocalDateTime.now();
        return User.builder()
                .username( userToRegister.getUsername() )
                // Password MUST BE encrypted here
                .password( this.encode(userToRegister.getPassword()) )
                .nickname( userToRegister.getNickname() )
                .email( userToRegister.getEmail() )
                .status( ENABLED_STATUS )
                .role( this.fetchRole(BASIC_USER_ROLE) )
                .successfulAuth( ZERO_AUTH_ATTEMPTS )
                .failedAuth( ZERO_AUTH_ATTEMPTS )
                .creationDate( now )
                .passwordExpirationDate( now.plusDays(EXPIRATION_DAYS) )
                .lastConnection( now )
                .build();
    }

    @Override
    public User create(User userToRegister) {
        User initialized = this.initialize(userToRegister);
        return this.userRepositoryPort.save(initialized);
    }

}
