package com.quathar.codebay.application.inputport.security;

import com.quathar.codebay.application.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.application.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.application.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Granted Permission Service Port</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface GrantedPermissionServicePort extends CreateModelUseCase<GrantedPermission>, ReadModelUseCase<GrantedPermission, UUID>, DeleteModelUseCase<UUID> {

    /**
     * Retrieves all roles grouped by their operations.
     *
     * @return A list of {@link RoleOperations} models, each representing a role with its operations.
     */
    List<RoleOperations> getAllGroupedByRole();

    /**
     * Retrieves all roles grouped by their operations, paginated.
     *
     * @param pageIndex The index of the page to retrieve.
     * @param pageSize  The size of the page.
     * @return A list of {@link RoleOperations} models, each representing a role with its operations.
     */
    List<RoleOperations> getAllGroupedByRole(int pageIndex, int pageSize);

}
