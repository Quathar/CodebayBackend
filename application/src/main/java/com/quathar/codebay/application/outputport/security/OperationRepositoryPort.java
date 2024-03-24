package com.quathar.codebay.application.outputport.security;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.domain.model.security.Operation;

/**
 * <h1>Operation Repository Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface OperationRepositoryPort extends CrudRepositoryPort<Operation, java.util.UUID> {

    /**
     * Finds an operation by its name.
     *
     * @param operationName The name of the operation to find.
     * @return An Optional containing the found operation, or empty if not found.
     */
    java.util.Optional<Operation> findByName(String operationName);

}
