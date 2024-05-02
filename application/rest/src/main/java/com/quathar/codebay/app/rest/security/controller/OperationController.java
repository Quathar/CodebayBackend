package com.quathar.codebay.app.rest.security.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.api.authorization.OperationAPI;
import com.quathar.codebay.app.rest.security.model.factory.HttpSecurityFactory;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateOperationRequest;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateOperationRequest;
import com.quathar.codebay.app.service.security.OperationService;
import com.quathar.codebay.domain.model.security.Operation;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Operation Controller</h1>
 *
 * Controller for managing operations.
 *
 * @see OperationAPI
 * @see OperationService
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class OperationController implements OperationAPI {

    private static final Logger log = LoggerFactory.getLogger(OperationController.class);

    // <<-FIELD->>
    /**
     * The port for operation service.
     */
    private final OperationService operationService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<Operation> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        java.util.List<Operation> operations = this.operationService
                .getAll(pageIndex, pageSize)
                .toList();

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
        return this.operationService.getById(id);
    }

    @Override
    public Operation create(CreateOperationRequest createOperationRequest) {
        Operation operationToCreate = HttpSecurityFactory
                .setCreateOperationRequest()
                .toModel(createOperationRequest);

        log.debug("Creating operation: {}", createOperationRequest);

        return this.operationService.create(operationToCreate);
    }

    @Override
    public Operation update(UUID id, UpdateOperationRequest updateOperationRequest) {
        Operation operationToUpdate = HttpSecurityFactory
                .setUpdateOperationRequest()
                .toModel(updateOperationRequest);
        operationToUpdate.setId(id);

        log.debug("Updating operation with ID {}: {}", id, updateOperationRequest);

        return this.operationService.create(operationToUpdate);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting operation with ID: {}", id);
        this.operationService.deleteById(id);
    }

}
