package com.quathar.codebay.domain.usecase.security.token;

/**
 * <h1>Extract Username Use Case</h1>
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface ExtractUsernameUseCase {

    /**
     * Extracts the username from the provided JWT token.
     *
     * @param token The JWT token.
     * @return The username extracted from the token.
     */
    String extractUsername(String token);

}
