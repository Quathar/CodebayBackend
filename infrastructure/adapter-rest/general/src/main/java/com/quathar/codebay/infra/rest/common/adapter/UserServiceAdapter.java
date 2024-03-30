package com.quathar.codebay.infra.rest.common.adapter;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.Role;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <h1>User Service Adapter</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Component
public class       UserServiceAdapter
        extends    CrudService<User, java.util.UUID>
        implements UserServicePort {

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
    /**
     * Status indicating user is disabled.
     */
    private static final String DISABLED_STATUS = "DISABLED";

    // <<-FIELDS->>
    /**
     * The user repository port.
     */
    private final UserRepositoryPort userRepositoryPort;
    /**
     * The role repository port.
     */
    private final RoleRepositoryPort roleRepositoryPort;
    /**
     * The password encoder used for encoding and hashing user passwords for security.
     */
    private final PasswordEncoder passwordEncoder;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a UserService with the specified ports.
     *
     * @param userRepositoryPort The port for user repository.
     * @param roleRepositoryPort The port for role repository.
     * @param passwordEncoder    The password encoder.
     */
    public UserServiceAdapter(
            UserRepositoryPort userRepositoryPort,
            RoleRepositoryPort roleRepositoryPort,
            PasswordEncoder    passwordEncoder
    ) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
        this.roleRepositoryPort = roleRepositoryPort;
        this.passwordEncoder    = passwordEncoder;
    }

    // <<-METHODS->>
    @Override
    public User getByUsername(String username) {
        return this.userRepositoryPort
                .findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Fetches a role by its name.
     *
     * @param roleName The name of the role to fetch
     * @return The role with the specified name
     */
    private Role fetchRole(String roleName) {
        return this.roleRepositoryPort
                .findByName( roleName )
                .get();
    }

    @Override
    public User create(User userToRegister) {
        var now  = java.time.LocalDateTime.now();
        var user = User.builder()
                .username( userToRegister.getUsername() )
                // Password MUST BE encrypted here
                .password( this.passwordEncoder.encode(userToRegister.getPassword()) )
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
        return this.userRepositoryPort.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        this.userRepositoryPort
                .findByUsername(username)
                .ifPresent(user -> {
                    user.setStatus(DISABLED_STATUS);
                    this.userRepositoryPort.save(user);
                });
    }

}
