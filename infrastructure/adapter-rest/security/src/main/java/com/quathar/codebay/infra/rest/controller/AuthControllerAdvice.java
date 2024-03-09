package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.domain.exception.InvalidCredentialsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <h1>Authentication Controller Advice</h1>
 * <br>
 * <p>
 *     Handles exceptions and provides appropriate responses.
 * </p>
 *
 * @since 2023-11-28
 * @version 1.0
 * @author Q
 */
@RestControllerAdvice
public class AuthControllerAdvice {

    /**
     * Handles InvalidCredentialsException.
     *
     * @return a ResponseEntity with an UNAUTHORIZED status
     */
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Void> invalidCredentialsHandler() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
