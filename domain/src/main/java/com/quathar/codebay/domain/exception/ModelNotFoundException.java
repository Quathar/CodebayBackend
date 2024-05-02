package com.quathar.codebay.domain.exception;

import lombok.NoArgsConstructor;

/**
 * <h1>Model Not Found Exception</h1>
 *
 * Exception indicating that a requested model was not found.
 *
 * @see RuntimeException
 * @since 2023-03-30
 * @version 1.0
 * @author Q
 */
@NoArgsConstructor
public class ModelNotFoundException extends RuntimeException {

    /**
     * Constructs a new ModelNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ModelNotFoundException(String message) {
        super(message);
    }

}
