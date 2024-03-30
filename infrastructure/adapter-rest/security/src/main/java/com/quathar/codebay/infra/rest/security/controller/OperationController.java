package com.quathar.codebay.infra.rest.security.controller;

import com.quathar.codebay.application.inputport.security.OperationServicePort;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.infra.rest.common.factory.HttpCommonFactory;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.rest.security.api.OperationAPI;
import com.quathar.codebay.infra.rest.security.factory.HttpSecurityFactory;
import com.quathar.codebay.infra.rest.security.model.request.CreateOperationRequest;
import com.quathar.codebay.infra.rest.security.model.request.UpdateOperationRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Operation Controller</h1>
 *
 * Controller for managing operations.
 *
 * @see OperationAPI
 * @see OperationServicePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
public class OperationController implements OperationAPI {

    private static final Logger log = LoggerFactory.getLogger(OperationController.class);

    // <<-FIELD->>
    /**
     * The port for operation service.
     */
    private final OperationServicePort operationServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code OperationController} with the specified {@code OperationServicePort}.
     *
     * @param operationServicePort The port for operation service.
     */
    @Autowired
    public OperationController(OperationServicePort operationServicePort) {
        this.operationServicePort = operationServicePort;
    }

    // <<-METHODS->>
    @Override
    public PageContentResponse<Operation> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        java.util.List<Operation> operations = this.operationServicePort.getAll(pageIndex, pageSize);

        log.debug("Retrieving all operations with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                operations.size(),
                operations
        );
    }

    @Override
    public Operation getById(UUID id) {
        log.debug("Retrieving operation with ID: {}", id);
        return this.operationServicePort.getById(id);
    }

    @Override
    public Operation create(CreateOperationRequest createOperationRequest) {
        Operation operationToCreate = HttpSecurityFactory
                .setCreateOperationRequest()
                .toModel(createOperationRequest);

        log.debug("Creating operation: {}", createOperationRequest);

        return this.operationServicePort.create(operationToCreate);
    }

    @Override
    public Operation update(UUID id, UpdateOperationRequest updateOperationRequest) {
        Operation operationToUpdate = HttpSecurityFactory
                .setUpdateOperationRequest()
                .toModel(updateOperationRequest);
        operationToUpdate.setId(id);

        log.debug("Updating operation with ID {}: {}", id, updateOperationRequest);

        return this.operationServicePort.create(operationToUpdate);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting operation with ID: {}", id);
        this.operationServicePort.deleteById(id);
    }

}
