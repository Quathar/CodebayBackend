package com.quathar.codebay.infra.rest.security.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;

import com.quathar.codebay.domain.exception.InvalidCredentialsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

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
     * Handles {@code InvalidCredentialsException}.
     *
     * @return A map containing the error message for invalid credentials.
     */
    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleInvalidCredentialsException() {
        log.debug("Invalid credentials exception occurred.");
        return Map.of("error", "Invalid Credentials");
    }

    /**
     * Handles {@code AuthenticationException}.
     *
     * @return A map containing the error message for authentication failure.
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
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
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleBadCredentialsException(BadCredentialsException exception) {
        log.debug("Bad credentials exception occurred.");
        // Return the same message of 'AuthenticationException'
        // so that a malicious user does not know if the username entered was correct.
        return Map.of("error", "Invalid credentials");
    }

    /**
     * Handles {@code JWTVerificationException}.
     *
     * @return A map containing the error message for JWT verification failure.
     */
    @ExceptionHandler(JWTVerificationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleJWTVerificationException() {
        log.debug("JWT verification exception occurred.");
        return Map.of("error", "Invalid token");
    }

    /**
     * Handles {@code AccessDeniedException}.
     *
     * @return A map containing the error message for access denied.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handleAccessDeniedException(AccessDeniedException exception) {
        if (SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .equals("anonymousUser")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(this.handleInvalidCredentialsException());
        }
        log.debug("ACCESS DENIED");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(Map.of("error", "ACCESS DENIED"));
    }

}
