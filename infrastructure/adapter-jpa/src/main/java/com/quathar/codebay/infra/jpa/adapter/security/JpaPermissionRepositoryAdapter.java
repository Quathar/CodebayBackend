package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.mapper.security.PermissionMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Permission Repository Adapter</h1>
 *
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
     * Mapper for converting between GrantedPermission and GrantedPermissionEntity
     * and custom projections and domain model.
     */
    private final PermissionMapper permissionMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaGrantedPermissionRepositoryAdapter} with the specified JpaGrantedPermissionRepository.
     *
     * @param jpaPermissionRepository The JPA repository for GrantedPermission entities.
     */
    @Autowired
    public JpaPermissionRepositoryAdapter(JpaPermissionRepository jpaPermissionRepository) {
        super(jpaPermissionRepository, PermissionMapper.INSTANCE);
        this.jpaPermissionRepository = jpaPermissionRepository;
        this.permissionMapper        = PermissionMapper.INSTANCE;
    }

    // <<-METHOD->>
    @Override
    public java.util.List<RoleOperations> findAllGroupedByRole() {
        return this.jpaPermissionRepository
                .findAllAndGroupByRole()
                .stream()
                .map(this.permissionMapper::toRoleOperations)
                .toList();
    }

}
