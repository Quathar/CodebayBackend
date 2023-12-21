package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.outputport.AdminRepositoryPort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.util.HashManager;
import com.quathar.codebay.application.util.TokenManager;
import com.quathar.codebay.domain.exception.InvalidCredentialsException;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.domain.model.User;

import java.time.LocalDateTime;

/**
 * <h1>Authentication Service</h1>
 * <br>
 * <p>
 *     Provides authentication services.
 * </p>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public class AuthService implements AuthServicePort {

    // <<-FIELD->>
    /**
     * Repository port for handling operations related to Admin entities.
     */
    private final AdminRepositoryPort adminRepositoryPort;
    /**
     * Repository port for handling operations related to User entities.
     */
    private final UserRepositoryPort  userRepositoryPort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs an instance of AuthService.
     *
     * @param adminRepositoryPort The repository port for Admin entities.
     * @param userRepositoryPort  The repository port for User entities.
     */
    public AuthService(AdminRepositoryPort adminRepositoryPort, UserRepositoryPort userRepositoryPort) {
        this.adminRepositoryPort = adminRepositoryPort;
        this.userRepositoryPort  = userRepositoryPort;
    }

    // <<-METHODS->>
    /**
     * Authenticates an admin by verifying the provided password against the stored admin password.
     *
     * @param administrator    The admin model representing the admin to be authenticated.
     * @param passwordToVerify The password to verify against the stored admin password.
     * @return A TokenPair containing the generated refresh and access tokens upon successful authentication.
     * @throws InvalidCredentialsException if the provided password does not match the administrator's stored password.
     */
    private TokenPair authenticateAdmin(Administrator administrator, String passwordToVerify) {
        if (!HashManager.matches(passwordToVerify, administrator.getPassword())) {
            Integer failedAuth = administrator.getFailedAuth();
            administrator.setFailedAuth(++failedAuth);
            this.adminRepositoryPort.save(administrator);

            throw new InvalidCredentialsException();
        }

        Integer successfulAuth = administrator.getSuccessfulAuth();
        administrator.setSuccessfulAuth(++successfulAuth);
        administrator.setLastConnection(LocalDateTime.now());
        this.adminRepositoryPort.save(administrator);

        return TokenManager.generateTokenPair(administrator.getId().toString(), TokenManager.Role.ADMIN);
    }

    /**
     * Authenticates a user by verifying the provided password against the stored user password.
     *
     * @param user             The user model representing the user to be authenticated.
     * @param passwordToVerify The password to verify against the stored user password.
     * @return A TokenPair containing the generated refresh and access tokens upon successful authentication.
     * @throws InvalidCredentialsException if the provided password does not match the user's stored password.
     */
    private TokenPair authenticateUser(User user, String passwordToVerify) {
        if (!HashManager.matches(passwordToVerify, user.getPassword())) {
            Integer failedAuth = user.getFailedAuth();
            user.setFailedAuth(++failedAuth);
            this.userRepositoryPort.save(user);

            throw new InvalidCredentialsException();
        }

        Integer successfulAuth = user.getSuccessfulAuth();
        user.setSuccessfulAuth(++successfulAuth);
        user.setLastConnection(LocalDateTime.now());
        this.userRepositoryPort.save(user);

        return TokenManager.generateTokenPair(user.getId().toString());
    }

    @Override
    public TokenPair authAdminByUsername(String username, String password) {
        Administrator admin = this.adminRepositoryPort.findByUsername(username).orElseThrow(InvalidCredentialsException::new);
        return this.authenticateAdmin(admin, password);
    }

    @Override
    public TokenPair authAdminByEmail(String email, String password) {
        Administrator admin = this.adminRepositoryPort.findByEmail(email).orElseThrow(InvalidCredentialsException::new);
        return this.authenticateAdmin(admin, password);
    }

    @Override
    public TokenPair authByUsername(String username, String password) {
        User user = this.userRepositoryPort.findByUsername(username).orElseThrow(InvalidCredentialsException::new);
        return this.authenticateUser(user, password);
    }

    @Override
    public TokenPair authByEmail(String email, String password) {
        User user = this.userRepositoryPort.findByEmail(email).orElseThrow(InvalidCredentialsException::new);
        return this.authenticateUser(user, password);
    }

}
