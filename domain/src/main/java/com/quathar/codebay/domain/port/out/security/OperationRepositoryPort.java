package com.quathar.codebay.domain.port.out.security;

import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

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
