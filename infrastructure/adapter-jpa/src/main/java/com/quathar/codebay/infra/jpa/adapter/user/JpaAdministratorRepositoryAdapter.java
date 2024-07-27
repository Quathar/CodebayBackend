package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.AdministratorMapper;
import com.quathar.codebay.infra.jpa.repository.user.JpaAdministratorRepository;

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
     * Mapper for converting between {@link Administrator} and {@link AdministratorEntity}.
     */
    private final AdministratorMapper adminMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaAdministratorRepositoryAdapter} for the {@link AdministratorRepositoryPort}
     * with the specified {@link JpaAdministratorRepository} and {@link AdministratorMapper}.
     *
     * @param jpaAdminRepository The JPA repository for {@link AdministratorEntity}.
     * @param adminMapper        The mapper for converting between {@link Administrator} and {@link AdministratorEntity}.
     */
    public JpaAdministratorRepositoryAdapter(JpaAdministratorRepository jpaAdminRepository, AdministratorMapper adminMapper) {
        super(jpaAdminRepository, adminMapper);
        this.jpaAdminRepository = jpaAdminRepository;
        this.adminMapper        = adminMapper;
    }

    // <<-METHODS->>

}
