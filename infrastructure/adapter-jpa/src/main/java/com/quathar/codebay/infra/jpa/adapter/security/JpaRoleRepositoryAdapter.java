package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Operation Repository Adapter</h1>
 *
 * @see RoleRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see Role
 * @see RoleEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaRoleRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<Role, RoleEntity, java.util.UUID>
       implements  RoleRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for Role entities.
     */
    private final JpaRoleRepository jpaRoleRepository;
    /**
     * Mapper for converting between {@link Role} and {@link RoleEntity}.
     */
    private final RoleMapper roleMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaRoleRepositoryAdapter} for the {@link RoleRepositoryPort}
     * with the specified {@link JpaRoleRepository} and {@link RoleMapper}.
     *
     * @param jpaRoleRepository The JPA repository for {@link RoleEntity}.
     * @param roleMapper        The mapper for converting between {@link Role} and {@link RoleEntity}.
     */
    @Autowired
    public JpaRoleRepositoryAdapter(JpaRoleRepository jpaRoleRepository, RoleMapper roleMapper) {
        super(jpaRoleRepository, roleMapper);
        this.jpaRoleRepository = jpaRoleRepository;
        this.roleMapper        = roleMapper;

    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<Role> findByName(String roleName) {
        return this.jpaRoleRepository
                .findByName(roleName)
                .map(this.roleMapper::toModel);
    }

}
