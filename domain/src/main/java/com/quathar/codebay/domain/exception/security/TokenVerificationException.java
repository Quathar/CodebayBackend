package com.quathar.codebay.domain.exception.security;

import lombok.NoArgsConstructor;

/**
 * <h1>Token Verification Exception</h1>
 *
 * Exception indicating that a token verification failed.
 *
 * @see RuntimeException
 * @since 2023-07-28
 * @version 1.0
 * @author Q
 */
@NoArgsConstructor
public class TokenVerificationException extends RuntimeException {

    // <<-CONSTRUCTOR->>
    public TokenVerificationException(Throwable e) {
        super(e);
    }

}
