package com.quathar.codebay.application.inputport.security;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.usecase.crud.ReadAllUseCase;
import com.quathar.codebay.domain.usecase.crud.ReadUseCase;
import com.quathar.codebay.domain.usecase.security.permission.GrantPermissionUseCase;
import com.quathar.codebay.domain.usecase.security.permission.ReadAllPermissionsGroupedByRoleUseCase;
import com.quathar.codebay.domain.usecase.security.permission.RevokePermissionUseCase;

/**
 * <h1>Permission Service Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface PermissionServicePort
       extends   ReadAllUseCase<GrantedPermission>,
                 ReadUseCase<GrantedPermission, java.util.UUID>,
                 ReadAllPermissionsGroupedByRoleUseCase,
                 GrantPermissionUseCase,
                 RevokePermissionUseCase {
}
