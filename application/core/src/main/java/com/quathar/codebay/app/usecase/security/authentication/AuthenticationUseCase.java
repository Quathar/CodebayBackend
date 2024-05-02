package com.quathar.codebay.app.usecase.security.authentication;

import com.quathar.codebay.domain.port.in.security.AuthenticationUseCasePort;
import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Authentication Use Case Implementation</h1>
 *
 * @see AuthenticationUseCasePort
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class AuthenticationUseCase implements AuthenticationUseCasePort {

    // <<-FIELD->>
    /**
     * The authentication manager port.
     */
    @NonNull
    private final AuthenticationManagerPort authenticationManagerPort;

    // <<-METHOD->>
    @Override
    public TokenPair authenticate(String authenticationKey, String password) {
        return this.authenticationManagerPort.performAuthentication(authenticationKey, password);
    }

}
