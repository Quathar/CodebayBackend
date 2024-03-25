package com.quathar.codebay.infra.security.controller;

import com.quathar.codebay.application.inputport.security.GrantedPermissionServicePort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.infra.rest.common.factory.HttpCommonFactory;
import com.quathar.codebay.infra.rest.common.model.request.PageContentRequest;
import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;
import com.quathar.codebay.infra.security.api.PermissionAPI;
import com.quathar.codebay.infra.security.factory.HttpSecurityFactory;
import com.quathar.codebay.infra.security.model.request.GrantPermissionRequest;
import com.quathar.codebay.infra.security.model.response.GrantedPermissionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Permission Controller</h1>
 *
 * Controller for managing permissions.
 *
 * @see PermissionAPI
 * @see GrantedPermissionServicePort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@RestController
public class PermissionController implements PermissionAPI {

    private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    // <<-FIELD->>
    /**
     * The port for granted permission service.
     */
    private final GrantedPermissionServicePort grantedPermissionServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a {@code GrantedPermissionController} with the specified {@code GrantedPermissionServicePort}.
     *
     * @param grantedPermissionServicePort The port for granted permission service.
     */
    @Autowired
    public PermissionController(GrantedPermissionServicePort grantedPermissionServicePort) {
        this.grantedPermissionServicePort = grantedPermissionServicePort;
    }

    // <<-METHODS->>
    @Override
    public PageContentResponse<GrantedPermissionResponse> getAll(PageContentRequest pageContentRequest) {
        Integer pageIndex = pageContentRequest.page();
        Integer pageSize  = pageContentRequest.size();
        List<GrantedPermissionResponse> grantedPermissions = this.grantedPermissionServicePort
                .getAll( pageIndex, pageSize )
                .stream()
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
        List<RoleOperations> grantedPermissionsGroupedByRole = this.grantedPermissionServicePort.getAllGroupedByRole();

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
        GrantedPermission grantedPermission = this.grantedPermissionServicePort.getById(id);
        return HttpSecurityFactory.getGrantedPermissionResponse().fromModel(grantedPermission);
    }

    @Override
    public GrantedPermissionResponse grant(GrantPermissionRequest grantPermissionRequest) {
        GrantedPermission permissionToBeGranted = HttpSecurityFactory
                .setGrantPermissionRequest()
                .toModel(grantPermissionRequest);

        log.debug("Granting permission: {}", grantPermissionRequest);

        GrantedPermission grantedPermission = this.grantedPermissionServicePort.create(permissionToBeGranted);
        return HttpSecurityFactory.getGrantedPermissionResponse().fromModel(grantedPermission);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Deleting granted permission with ID: {}", id);
        this.grantedPermissionServicePort.deleteById(id);
    }

}
