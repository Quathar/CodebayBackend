package com.quathar.codebay.app.rest.security.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * <h1>Authentication Controller Advice</h1>
 *
 * Handles exceptions and provides appropriate responses.
 *
 * @since 2023-11-28
 * @version 1.0
 * @author Q
 */
@RestControllerAdvice
public class SecurityControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(SecurityControllerAdvice.class);

    // <<-METHODS->>
    /**
     * Handles {@code AuthenticationException}.
     *
     * @return A map containing the error message for authentication failure.
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(UNAUTHORIZED)
    public Map<String, String> handleAuthenticationException(AuthenticationException exception) {
        log.debug("Authentication exception occurred.");
        return Map.of("error", "Invalid credentials");
    }

    /**
     * Handles {@code BadCredentialsException}.
     *
     * @return A map containing the error message for authentication failure.
     */
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(UNAUTHORIZED)
    public Map<String, String> handleBadCredentialsException(BadCredentialsException exception) {
        log.debug("Bad credentials exception occurred.");
        // Return the same message of 'AuthenticationException'
        // so that a malicious user does not know if the username entered was correct.
        return Map.of("error", "Invalid credentials");
    }

    /**
     * Handles {@code AccessDeniedException}.
     *
     * @return A map containing the error message for access denied.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handleAccessDeniedException(AccessDeniedException exception) {
        var username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .toString();

        boolean isAnonymous = "anonymousUser".equals(username);
        if (isAnonymous)
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(Map.of("error", "Invalid Credentials"));
        log.debug("ACCESS DENIED for user [ {} ]" , username);
        return ResponseEntity
                .status(FORBIDDEN)
                .body(Map.of("error", "ACCESS DENIED"));
    }

}
