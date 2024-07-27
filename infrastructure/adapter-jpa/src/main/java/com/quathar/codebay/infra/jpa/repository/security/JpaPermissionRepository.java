package com.quathar.codebay.infra.jpa.repository.security;

import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.projection.RoleWithOperationsProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <h1>JPA (Java Persistence API) Permission Repository</h1>
 *
 * @see GrantedPermissionEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface JpaPermissionRepository extends JpaRepository<GrantedPermissionEntity,  java.util.UUID> {

    /**
     * Retrieves a list of roles with their associated operations grouped by role.
     *
     * @return A list of {@link RoleWithOperationsProjection} containing roles and their associated operations
     */
    @Query(value = """
        SELECT
            r.name AS roleName,
            JSON_ARRAYAGG(o.name) AS operationsInJson
        FROM Granted_Permission gp
            JOIN Role r ON gp.role_id = r.id
            JOIN Operation o ON gp.operation_id = o.id
        GROUP BY r.name;
        """, nativeQuery = true)
    java.util.List<RoleWithOperationsProjection> findAllAndGroupByRole();

}
