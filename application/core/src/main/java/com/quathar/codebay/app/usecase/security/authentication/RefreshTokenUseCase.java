package com.quathar.codebay.app.usecase.security.authentication;

import com.quathar.codebay.domain.port.in.security.RefreshTokenUseCasePort;
import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Refresh Token Use Case Implementation</h1>
 *
 * @see RefreshTokenUseCasePort
 * @since 2024-07-28
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class RefreshTokenUseCase implements RefreshTokenUseCasePort {

    // <<-FIELD->>
    /**
     * The authentication manager port.
     */
    @NonNull
    private final AuthenticationManagerPort authenticationManagerPort;

    // <<-METHOD->>
    @Override
    public TokenPair refresh(String token) {
        return this.authenticationManagerPort.performRefresh(token);
    }

}
