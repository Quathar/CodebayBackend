package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.AuthenticationServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.domain.usecase.security.AuthenticationUseCase;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Authentication Service</h1>
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class AuthenticationService implements AuthenticationServicePort {

    // <<-FIELD->>
    @NonNull private final AuthenticationUseCase authenticationUseCase;

    // <<-METHOD->>
    @Override
    public TokenPair performAuthentication(Object authenticationKey, String password) {
        return this.authenticationUseCase.performAuthentication(authenticationKey, password);
    }

}
