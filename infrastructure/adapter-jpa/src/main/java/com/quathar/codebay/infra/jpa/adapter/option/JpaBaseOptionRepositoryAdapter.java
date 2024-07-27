package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.BaseOptionRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.BaseOption;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.option.BaseOptionEntity;
import com.quathar.codebay.infra.jpa.mapper.option.BaseOptionMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaBaseOptionRepository;

/**
 * <h1>JPA (Java Persistence API) Base Option Repository Adapter</h1>
 *
 * @param <M> The source type (Model) for mapping.
 * @param <T> The target type (Entity) for mapping.
 *
 * @see BaseOptionRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see BaseOption
 * @see BaseOptionEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
public abstract class JpaBaseOptionRepositoryAdapter<M extends BaseOption, T extends BaseOptionEntity>
       extends        JpaCrudRepositoryAdapter<M, T, String>
       implements     BaseOptionRepositoryPort<M> {

    // <<-FIELDS->>
    /**
     * The JPA repository for BaseOption entities.
     */
    private final JpaBaseOptionRepository<T> jpaBaseOptionRepository;
    /**
     * Mapper for converting between {@link BaseOption} and {@link BaseOptionEntity}.
     */
    private final BaseOptionMapper<M, T> baseOptionMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaBaseOptionRepositoryAdapter} for the {@link BaseOptionRepositoryPort}
     * with the specified {@link JpaBaseOptionRepository} and {@link BaseOptionMapper}.
     *
     * @param jpaBaseOptionRepository The JPA repository for {@link BaseOptionEntity}.
     * @param baseOptionMapper        The mapper for converting between {@link BaseOption} and {@link BaseOptionEntity}.
     */
    public JpaBaseOptionRepositoryAdapter(JpaBaseOptionRepository<T> jpaBaseOptionRepository, BaseOptionMapper<M, T> baseOptionMapper) {
        super(jpaBaseOptionRepository, baseOptionMapper);
        this.jpaBaseOptionRepository = jpaBaseOptionRepository;
        this.baseOptionMapper        = baseOptionMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<M> findAll() {
        return this.jpaBaseOptionRepository
                .findAll()
                .stream()
                .map(this.baseOptionMapper::toModel);
    }

}
