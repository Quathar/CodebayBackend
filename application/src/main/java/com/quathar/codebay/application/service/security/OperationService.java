package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.OperationServicePort;
import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.service.CrudService;
import com.quathar.codebay.domain.model.security.Operation;

/**
 * <h1>Operation Service</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public class      OperationService
       extends    CrudService<Operation, java.util.UUID>
       implements OperationServicePort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a OperationService with the specified OperationRepositoryPort.
     *
     * @param operationRepositoryPort The port for operation repository
     */
    public OperationService(OperationRepositoryPort operationRepositoryPort) {
        super(operationRepositoryPort);
    }

}
