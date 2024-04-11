package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.JwtServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.domain.usecase.security.token.ExtractUsernameUseCase;
import com.quathar.codebay.domain.usecase.security.token.GenerateTokenPairUseCase;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>JWT (JSON Web Token) Service</h1>
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public final class JwtService implements JwtServicePort {

    // <<-FIELDS->>
    @NonNull private final GenerateTokenPairUseCase generateTokenPairUseCase;
    @NonNull private final ExtractUsernameUseCase   extractUsernameUseCase;

    // <<-METHODS->>
    @Override
    public TokenPair generateTokenPair(String subject, java.util.Map<String, ?> extraClaims) {
        return this.generateTokenPairUseCase.generateTokenPair(subject, extraClaims);
    }

    @Override
    public TokenPair generateTokenPair(String subject) {
        return this.generateTokenPairUseCase.generateTokenPair(subject);
    }

    @Override
    public String extractUsername(String token) {
        return this.extractUsernameUseCase.extractUsername(token);
    }

}
