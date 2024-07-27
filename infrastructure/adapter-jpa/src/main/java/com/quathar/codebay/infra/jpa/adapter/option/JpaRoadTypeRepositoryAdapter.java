package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.RoadTypeRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.RoadType;
import com.quathar.codebay.infra.jpa.entity.option.RoadTypeEntity;
import com.quathar.codebay.infra.jpa.mapper.option.RoadTypeMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaRoadTypeRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Road Type Repository Adapter</h1>
 *
 * @see RoadTypeRepositoryPort
 * @see JpaBaseOptionRepositoryAdapter
 * @see RoadType
 * @see RoadTypeEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaRoadTypeRepositoryAdapter
       extends     JpaBaseOptionRepositoryAdapter<RoadType, RoadTypeEntity>
       implements  RoadTypeRepositoryPort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaRoadTypeRepositoryAdapter} for the {@link RoadTypeRepositoryPort}
     * with the specified {@link JpaRoadTypeRepository} and {@link RoadTypeMapper}.
     *
     * @param jpaRoadTypeRepository The JPA repository for {@link RoadTypeEntity}.
     * @param roadTypeMapper        The mapper for converting between {@link RoadType} and {@link RoadTypeEntity}.
     */
    public JpaRoadTypeRepositoryAdapter(JpaRoadTypeRepository jpaRoadTypeRepository, RoadTypeMapper roadTypeMapper) {
        super(jpaRoadTypeRepository, roadTypeMapper);
    }

}
