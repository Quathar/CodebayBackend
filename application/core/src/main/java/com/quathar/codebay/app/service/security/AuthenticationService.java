package com.quathar.codebay.app.service.security;

import com.quathar.codebay.domain.port.in.security.AuthenticationUseCasePort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Authentication Service</h1>
 *
 * @see AuthenticationUseCasePort
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class AuthenticationService
       implements  AuthenticationUseCasePort {

    // <<-FIELD->>
    @NonNull private AuthenticationUseCasePort authenticationUseCase;

    // <<-METHOD->>
    @Override
    public TokenPair authenticate(String authenticationKey, String password) {
        return this.authenticationUseCase.authenticate(authenticationKey, password);
    }

}
