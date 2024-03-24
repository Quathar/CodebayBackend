package com.quathar.codebay.infra.rest.common.controller;

import com.quathar.codebay.domain.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>Common Controller Advice</h1>
 *
 * Handles common exceptions and provides appropriate responses.
 *
 * @since 2023-11-28
 * @version 1.0
 * @author Q
 */
@RestControllerAdvice
public class CommonControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(CommonControllerAdvice.class);

    // <<-METHODS->>
    /**
     * Handles ResourceNotFoundException.
     *
     * @return a ResponseEntity with a NOT FOUND status
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> notFoundHandler() {
        log.debug("Handling ResourceNotFoundException");
        // There is no need to have both @ annotation
        // and ResponseEntity return type
        // We could make this method void
        // or quit @ResponseStatus
        // I will leave this here to know that both ways exist.
        return ResponseEntity.notFound().build();
    }

    /**
     * Handles MethodArgumentNotValidException.
     *
     * @param exception The MethodArgumentNotValidException to handle.
     * @return A map containing the validation errors.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, ?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var message = "Validation error";

        Map<String, java.util.List<String>> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(
                                FieldError::getDefaultMessage,
                                Collectors.toList()
                        )
                ));

        log.debug("Handling MethodArgumentNotValidException: {}", validationErrors);

        return Map.of(
                "timestamp", java.time.LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.name(),
                "message", message,
                "errors", validationErrors
        );
    }

}
