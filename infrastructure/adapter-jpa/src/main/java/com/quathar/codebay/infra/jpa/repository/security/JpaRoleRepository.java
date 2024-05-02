package com.quathar.codebay.infra.jpa.repository.security;

import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) Role Repository</h1>
 *
 * @see RoleEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, java.util.UUID> {

    /**
     * Finds a role entity by its name.
     *
     * @param roleName The name of the role entity to find.
     * @return An Optional containing the found role entity, or empty if not found.
     */
    java.util.Optional<RoleEntity> findByName(String roleName);

}
