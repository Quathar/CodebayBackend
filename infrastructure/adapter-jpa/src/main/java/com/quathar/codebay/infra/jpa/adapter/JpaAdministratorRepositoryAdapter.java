package com.quathar.codebay.infra.jpa.adapter;

import com.quathar.codebay.application.outputport.AdministratorRepositoryPort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.AdministratorMapper;
import com.quathar.codebay.infra.jpa.repository.JpaAdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * <h1>JPA Admin Repository Adapter</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaAdministratorRepositoryAdapter
       extends    JpaCrudRepositoryAdapter<Administrator, AdministratorEntity, java.util.UUID>
       implements AdministratorRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for admin entities.
     */
    private final JpaAdministratorRepository jpaAdminRepository;
    /**
     * Mapper for converting between Administrator and AdministratorEntity.
     */
    private final AdministratorMapper adminMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaAdministratorRepositoryAdapter} with the specified JpaAdministratorRepository.
     *
     * @param jpaAdminRepository The JPA repository for Administrator entities.
     */
    @Autowired
    public JpaAdministratorRepositoryAdapter(JpaAdministratorRepository jpaAdminRepository) {
        super(jpaAdminRepository, AdministratorMapper.INSTANCE);
        this.jpaAdminRepository = jpaAdminRepository;
        this.adminMapper        = AdministratorMapper.INSTANCE;
    }

    // <<-METHODS->>
    @Override
    public Optional<Administrator> findByUsername(String username) {
        return this.jpaAdminRepository
                .findByUsername(username)
                .map(this.adminMapper::toModel);
    }

    @Override
    public Optional<Administrator> findByEmail(String email) {
        return this.jpaAdminRepository
                .findByEmail(email)
                .map(this.adminMapper::toModel);
    }

}
