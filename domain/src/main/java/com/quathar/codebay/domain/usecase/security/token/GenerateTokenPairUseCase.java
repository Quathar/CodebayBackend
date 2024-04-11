package com.quathar.codebay.domain.usecase.security.token;

import com.quathar.codebay.domain.model.security.TokenPair;

/**
 * <h1>Generate Token Pair Use Case</h1>
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface GenerateTokenPairUseCase {

    /**
     * Generates a pair of JWT tokens (access token and refresh token) for the specified subject
     * along with additional custom claims.
     *
     * @param subject     The subject for which the tokens are generated.
     * @param extraClaims Additional custom claims to be included in the tokens.
     * @return A {@link TokenPair} of JWT.
     */
    TokenPair generateTokenPair(String subject, java.util.Map<String, ?> extraClaims);

    /**
     * Generates a pair of JWT tokens (access token and refresh token) for the specified subject.
     *
     * @param subject The subject for which the tokens are generated.
     * @return A {@link TokenPair} of JWT.
     */
    TokenPair generateTokenPair(String subject);

}
