package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.domain.exception.InvalidCredentialsException;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <h1>Exception Controller Advice</h1>
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
public class ExceptionControllerAdvice {

    /**
     * Handles ResourceNotFoundException.
     *
     * @return a ResponseEntity with a NOT_FOUND status
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> notFoundHandler() {
        // There is no need to have both @ annotation
        // and ResponseEntity return type
        // We could make this method void
        // or quit @ResponseStatus
        // I will leave this here to know that both ways exist.
        return ResponseEntity.notFound().build();
    }

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
