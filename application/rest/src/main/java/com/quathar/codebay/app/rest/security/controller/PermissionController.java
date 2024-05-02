package com.quathar.codebay.app.rest.security.controller;

import com.quathar.codebay.app.rest.common.model.factory.HttpCommonFactory;
import com.quathar.codebay.app.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.app.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.app.rest.security.api.authorization.PermissionAPI;
import com.quathar.codebay.app.rest.security.model.factory.HttpSecurityFactory;
import com.quathar.codebay.app.rest.security.model.request.authorization.GrantPermissionRequest;
import com.quathar.codebay.app.rest.security.model.response.GrantedPermissionResponse;
import com.quathar.codebay.app.service.security.PermissionService;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Permission Controller</h1>
 *
 * Controller for managing permissions.
 *
 * @see PermissionAPI
 * @see PermissionService
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class PermissionController implements PermissionAPI {

    private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    // <<-FIELD->>
    /**
     * The port for granted permission service.
     */
    private final PermissionService permissionService;

    // <<-METHODS->>
    @Override
    public PageContentResponse<GrantedPermissionResponse> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        List<GrantedPermissionResponse> grantedPermissions = this.permissionService
                .getAll( pageIndex, pageSize )
                .map( HttpSecurityFactory.getGrantedPermissionResponse()::fromModel )
                .toList();

        log.debug("Retrieving all granted permissions with pageIndex {} and pageSize {}.", pageIndex, pageSize);

        return HttpCommonFactory.getPageContentResponse(
                pageIndex,
                grantedPermissions.size(),
                grantedPermissions
        );
    }

    @Override
    public PageContentResponse<RoleOperations> getAllGroupedByRole() {
        List<RoleOperations> grantedPermissionsGroupedByRole = this.permissionService
                .getAllGroupedByRole()
                .toList();

        log.debug("Retrieving all granted permissions grouped by role");

        return HttpCommonFactory.getPageContentResponse(
                null,
                grantedPermissionsGroupedByRole.size(),
                grantedPermissionsGroupedByRole
        );
    }

    @Override
    public GrantedPermissionResponse getById(UUID id) {
        log.debug("Retrieving granted permission with ID: {}", id);
        GrantedPermission grantedPermission = this.permissionService.getById(id);
        return HttpSecurityFactory.getGrantedPermissionResponse().fromModel(grantedPermission);
    }

    @Override
    public GrantedPermissionResponse grant(GrantPermissionRequest grantPermissionRequest) {
        GrantedPermission grantedPermission = this.permissionService.grant(grantPermissionRequest.role(), grantPermissionRequest.operation());

        log.debug("Granting permission: {}", grantPermissionRequest);

        return HttpSecurityFactory
                .getGrantedPermissionResponse()
                .fromModel(grantedPermission);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting granted permission with ID: {}", id);
        this.permissionService.revoke(id);
    }

}
