package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.mapper.security.PermissionMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Permission Repository Adapter</h1>
 *
 * @see PermissionRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see GrantedPermission
 * @see GrantedPermissionEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaPermissionRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<GrantedPermission, GrantedPermissionEntity, java.util.UUID>
       implements  PermissionRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for GrantedPermission entities.
     */
    private final JpaPermissionRepository jpaPermissionRepository;
    /**
     * Mapper for converting between {@link GrantedPermission} and {@link GrantedPermissionEntity}
     * and custom projections and domain model.
     */
    private final PermissionMapper permissionMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaPermissionRepositoryAdapter} for the {@link PermissionRepositoryPort}
     * with the specified {@link JpaPermissionRepository} and {@link PermissionMapper}.
     *
     * @param jpaPermissionRepository The JPA repository for {@link GrantedPermissionEntity}.
     * @param permissionMapper        The mapper for converting between {@link GrantedPermission} and {@link GrantedPermissionEntity}.
     */
    @Autowired
    public JpaPermissionRepositoryAdapter(JpaPermissionRepository jpaPermissionRepository, PermissionMapper permissionMapper) {
        super(jpaPermissionRepository, permissionMapper);
        this.jpaPermissionRepository = jpaPermissionRepository;
        this.permissionMapper        = permissionMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<RoleOperations> findAllGroupedByRole() {
        return this.jpaPermissionRepository
                .findAllAndGroupByRole()
                .stream()
                .map(this.permissionMapper::toRoleOperations);
    }

}
