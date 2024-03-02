package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.domain.exception.ResourceNotFoundException;

/**
 * <h1>Read Token Use Case</h1>
 * <br>
 * <p>
 *     This interface defines the contract for reading domain model entities using a token
 * </p>
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface ReadTokenUseCase<M> {

    /**
     * Retrieves a domain model entity by its associated token.
     *
     * @param token the token used to identify the domain model entity
     * @return the domain model entity associated with the token
     * @throws ResourceNotFoundException if the domain model entity is not found
     */
    M getByToken(String token) throws ResourceNotFoundException;

}
