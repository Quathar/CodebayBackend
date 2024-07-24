package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.AdministratorMapper;
import com.quathar.codebay.infra.jpa.repository.user.JpaAdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA Admin Repository Adapter</h1>
 *
 * @see AdministratorRepositoryPort
 * @see Administrator
 * @see AdministratorEntity
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaAdministratorRepositoryAdapter
       extends     JpaAbstractUserRepositoryAdapter<Administrator, AdministratorEntity>
       implements  AdministratorRepositoryPort {

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
    public JpaAdministratorRepositoryAdapter(JpaAdministratorRepository jpaAdminRepository, AdministratorMapper adminMapper) {
        super(jpaAdminRepository, adminMapper);
        this.jpaAdminRepository = jpaAdminRepository;
        this.adminMapper        = adminMapper;
    }

    // <<-METHODS->>

}
