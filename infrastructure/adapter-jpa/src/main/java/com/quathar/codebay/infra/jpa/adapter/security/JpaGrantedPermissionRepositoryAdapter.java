package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.application.outputport.security.GrantedPermissionRepositoryPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.mapper.security.GrantedPermissionMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaGrantedPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Granted Permission Repository Adapter</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaGrantedPermissionRepositoryAdapter
       extends    JpaCrudRepositoryAdapter<GrantedPermission, GrantedPermissionEntity, java.util.UUID>
       implements GrantedPermissionRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for GrantedPermission entities.
     */
    private final JpaGrantedPermissionRepository jpaGrantedPermissionRepository;
    /**
     * Mapper for converting between GrantedPermission and GrantedPermissionEntity
     * and custom projections and domain model.
     */
    private final GrantedPermissionMapper grantedPermissionMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaGrantedPermissionRepositoryAdapter} with the specified JpaGrantedPermissionRepository.
     *
     * @param jpaGrantedPermissionRepository The JPA repository for GrantedPermission entities.
     */
    @Autowired
    public JpaGrantedPermissionRepositoryAdapter(JpaGrantedPermissionRepository jpaGrantedPermissionRepository) {
        super(jpaGrantedPermissionRepository, GrantedPermissionMapper.INSTANCE);
        this.jpaGrantedPermissionRepository = jpaGrantedPermissionRepository;
        this.grantedPermissionMapper        = GrantedPermissionMapper.INSTANCE;
    }

    // <<-METHOD->>
    @Override
    public java.util.List<RoleOperations> findAllGroupedByRole() {
        return this.jpaGrantedPermissionRepository
                .findAllAndGroupByRole()
                .stream()
                .map(this.grantedPermissionMapper::toRoleOperations)
                .toList();
    }

}
