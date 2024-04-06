package com.quathar.codebay.domain.usecase.security;

/**
 * <h1>Password Matches Use Case</h1>
 *
 * @since 2024-04-04
 * @version 1.0
 * @author Q
 */
public interface PasswordMatchesUseCase {

    /**
     * Checks if the provided raw password matches the encoded password.
     *
     * @param rawPassword     The raw password to check
     * @param encodedPassword The encoded password to compare against
     * @return {@code true} if the raw password matches the encoded password, {@code false} otherwise
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
