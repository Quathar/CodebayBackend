package com.quathar.codebay.infra.jpa;

import com.quathar.codebay.application.outputport.AdminRepositoryPort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.AdminMapper;
import com.quathar.codebay.infra.jpa.repository.JpaAdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>JPA Admin Repository Adapter</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaAdminRepositoryAdapter
       extends    JpaRepositoryAdapter<Administrator, AdministratorEntity, UUID>
       implements AdminRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for admin entities.
     */
    private final JpaAdminRepository jpaAdminRepository;
    /**
     * Mapper for converting between Administrator and AdministratorEntity.
     */
    private final AdminMapper adminMapper;

    // <<-CONSTRUCTOR->>
    @Autowired
    public JpaAdminRepositoryAdapter(JpaAdminRepository jpaAdminRepository) {
        super(jpaAdminRepository, AdminMapper.getInstance());
        this.jpaAdminRepository = jpaAdminRepository;
        this.adminMapper        = AdminMapper.getInstance();
    }

    // <<-METHODS->>
    @Override
    public Optional<Administrator> findByUsername(String username) {
        return this.jpaAdminRepository.findByUsername(username).map(this.adminMapper::toModel);
    }

    @Override
    public Optional<Administrator> findByEmail(String email) {
        return this.jpaAdminRepository.findByEmail(email).map(this.adminMapper::toModel);
    }

}
