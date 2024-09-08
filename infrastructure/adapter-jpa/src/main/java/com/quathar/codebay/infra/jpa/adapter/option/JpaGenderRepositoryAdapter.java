package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.GenderRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.Gender;
import com.quathar.codebay.infra.jpa.entity.option.GenderEntity;
import com.quathar.codebay.infra.jpa.mapper.option.GenderMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaGenderRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Gender Repository Adapter</h1>
 *
 * @see GenderRepositoryPort
 * @see JpaBaseOptionRepositoryAdapter
 * @see Gender
 * @see GenderEntity
 * @since 2023-05-18
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaGenderRepositoryAdapter
       extends     JpaBaseOptionRepositoryAdapter<Gender, GenderEntity>
       implements  GenderRepositoryPort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaGenderRepositoryAdapter} for the {@link GenderRepositoryPort}
     * with the specified {@link JpaGenderRepository} and {@link GenderMapper}.
     *
     * @param jpaGenderRepository The JPA repository for {@link GenderEntity}.
     * @param genderMapper        The mapper for converting between {@link Gender} and {@link GenderEntity}.
     */
    public JpaGenderRepositoryAdapter(JpaGenderRepository jpaGenderRepository, GenderMapper genderMapper) {
        super(jpaGenderRepository, genderMapper);
    }

}
