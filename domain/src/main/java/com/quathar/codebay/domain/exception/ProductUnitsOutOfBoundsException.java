package com.quathar.codebay.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductUnitsOutOfBoundsException extends RuntimeException {

    /**
     * Constructs a new ModelNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ProductUnitsOutOfBoundsException(String message) {
        super(message);
    }

}
