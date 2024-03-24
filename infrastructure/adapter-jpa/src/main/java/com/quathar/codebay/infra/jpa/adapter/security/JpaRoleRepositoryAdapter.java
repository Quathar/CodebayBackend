package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Operation Repository Adapter</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaRoleRepositoryAdapter
       extends    JpaCrudRepositoryAdapter<Role, RoleEntity, java.util.UUID>
       implements RoleRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for Role entities.
     */
    private final JpaRoleRepository jpaRoleRepository;
    /**
     * Mapper for converting between Role and RoleEntity.
     */
    private final RoleMapper roleMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaRoleRepositoryAdapter} with the specified JpaRoleRepository.
     *
     * @param jpaRoleRepository The JPA repository for Role entities.
     */
    @Autowired
    public JpaRoleRepositoryAdapter(JpaRoleRepository jpaRoleRepository) {
        super(jpaRoleRepository, RoleMapper.INSTANCE);
        this.jpaRoleRepository = jpaRoleRepository;
        this.roleMapper        = RoleMapper.INSTANCE;
    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<Role> findByName(String roleName) {
        return this.jpaRoleRepository
                .findByName(roleName)
                .map(this.roleMapper::toModel);
    }

}
