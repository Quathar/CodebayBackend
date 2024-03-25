package com.quathar.codebay.infra.security.controller;

import com.quathar.codebay.application.inputport.security.RoleServicePort;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.infra.rest.common.factory.HttpCommonFactory;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.security.api.RoleAPI;
import com.quathar.codebay.infra.security.factory.HttpSecurityFactory;
import com.quathar.codebay.infra.security.model.request.CreateRoleRequest;
import com.quathar.codebay.infra.security.model.request.UpdateRoleRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Role Controller</h1>
 *
 * Controller for managing roles.
 *
 * @see RoleAPI
 * @see RoleServicePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
public class RoleController implements RoleAPI {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    // <<-FIELD->>
    /**
     * The port for role service.
     */
    private final RoleServicePort roleServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code RoleController} with the specified {@code RoleServicePort}.
     *
     * @param roleServicePort The port for role service.
     */
    @Autowired
    public RoleController(RoleServicePort roleServicePort) {
        this.roleServicePort = roleServicePort;
    }

    // <<-METHODS->>
    @Override
    public PageContentResponse<Role> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        java.util.List<Role> roles = this.roleServicePort.getAll(pageIndex, pageSize);

        log.debug("Retrieving all roles with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                roles.size(),
                roles
        );
    }

    @Override
    public Role getById(UUID id) {
        log.debug("Retrieving role with ID: {}", id);
        return this.roleServicePort.getById(id);
    }

    @Override
    public Role create(CreateRoleRequest createRoleRequest) {
        Role roleToCreate = HttpSecurityFactory
                .setCreateRoleRequest()
                .toModel(createRoleRequest);

        log.debug("Creating role: {}", createRoleRequest);

        return this.roleServicePort.create(roleToCreate);
    }

    @Override
    public Role update(UUID id, UpdateRoleRequest updateRoleRequest) {
        Role roleToUpdate = HttpSecurityFactory
                .setUpdateRoleRequest()
                .toModel(updateRoleRequest);
        roleToUpdate.setId(id);

        log.debug("Updating role with ID {}: {}", id, updateRoleRequest);

        return this.roleServicePort.create(roleToUpdate);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting role with ID: {}", id);
        this.roleServicePort.deleteById(id);
    }

}
