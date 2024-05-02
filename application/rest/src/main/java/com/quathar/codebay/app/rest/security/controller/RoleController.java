package com.quathar.codebay.app.rest.security.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.api.authorization.RoleAPI;
import com.quathar.codebay.app.rest.security.model.factory.HttpSecurityFactory;
import com.quathar.codebay.app.rest.security.model.request.authorization.CreateRoleRequest;
import com.quathar.codebay.app.rest.security.model.request.authorization.UpdateRoleRequest;
import com.quathar.codebay.app.rest.security.model.response.RoleResponse;
import com.quathar.codebay.app.service.security.RoleService;
import com.quathar.codebay.domain.model.security.Role;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>Role Controller</h1>
 *
 * Controller for managing roles.
 *
 * @see RoleAPI
 * @see RoleService
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class RoleController implements RoleAPI {

    private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    // <<-FIELD->>
    /**
     * The port for role service.
     */
    private final RoleService roleService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<RoleResponse> getAll(PageContentRequest pageContentRequest) {
        var pageIndex = pageContentRequest.page();
        var pageSize  = pageContentRequest.size();
        var roles     = this.roleService
                .getAll(pageIndex, pageSize)
                .map(HttpSecurityFactory.getRoleResponse()::fromModel)
                .toList();

        log.debug("Retrieving all roles with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                roles.size(),
                roles
        );
    }

    @Override
    public RoleResponse getById(UUID id) {
        Role role = this.roleService.getById(id);

        log.debug("Retrieving role with ID: {}", id);

        return HttpSecurityFactory
                .getRoleResponse()
                .fromModel(role);
    }

    @Override
    public RoleResponse create(CreateRoleRequest createRoleRequest) {
        Role roleToCreate = HttpSecurityFactory
                .setCreateRoleRequest()
                .toModel(createRoleRequest);
        Role createdRole = this.roleService.create(roleToCreate);

        log.debug("Creating role: {}", createRoleRequest);

        return HttpSecurityFactory
                .getRoleResponse()
                .fromModel(createdRole);
    }

    @Override
    public RoleResponse update(UUID id, UpdateRoleRequest updateRoleRequest) {
        Role roleToUpdate = HttpSecurityFactory
                .setUpdateRoleRequest()
                .toModel(updateRoleRequest);
        roleToUpdate.setId(id);
        Role updatedRole = this.roleService.create(roleToUpdate);

        log.debug("Updating role with ID {}: {}", id, updateRoleRequest);

        return HttpSecurityFactory
                .getRoleResponse()
                .fromModel(updatedRole);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting role with ID: {}", id);
        this.roleService.deleteById(id);
    }

}
