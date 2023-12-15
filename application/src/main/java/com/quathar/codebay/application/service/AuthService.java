package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.util.PasswordHasher;
import com.quathar.codebay.application.util.TokenManager;
import com.quathar.codebay.domain.exception.InvalidCredentialsException;
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
    private final UserRepositoryPort userRepositoryPort;

    // <<-CONSTRUCTOR->>
    public AuthService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    // <<-METHODS->>
    /**
     * Authenticates a user by verifying the provided password against the stored user password.
     *
     * @param user             The user model representing the user to be authenticated.
     * @param passwordToVerify The password to verify against the stored user password.
     * @return A TokenPair containing the generated refresh and access tokens upon successful authentication.
     * @throws InvalidCredentialsException if the provided password does not match the user's stored password.
     */
    private TokenPair authenticate(User user, String passwordToVerify) {
        if (!PasswordHasher.matches(passwordToVerify, user.getPassword())) {
            Integer failedAuth = user.getFailedAuth();
            user.setFailedAuth(++failedAuth);
            throw new InvalidCredentialsException();
        }

        Integer successfulAuth = user.getSuccessfulAuth();
        user.setSuccessfulAuth(++successfulAuth);
        user.setLastConnection(LocalDateTime.now());

        return TokenManager.generateTokenPair(user);
    }

    @Override
    public TokenPair authByUsername(String username, String password) {
        User user = this.userRepositoryPort.findByUsername(username).orElseThrow(InvalidCredentialsException::new);
        return this.authenticate(user, password);
    }

    @Override
    public TokenPair authByEmail(String email, String password) {
        User user = this.userRepositoryPort.findByEmail(email).orElseThrow(InvalidCredentialsException::new);
        return this.authenticate(user, password);
    }

}
