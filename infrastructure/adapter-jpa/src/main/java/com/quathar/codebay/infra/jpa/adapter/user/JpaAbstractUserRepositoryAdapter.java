package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.port.out.user.AbstractUserRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.UserEntity;
import com.quathar.codebay.infra.jpa.repository.user.JpaAbstractUserRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>JPA (Java Persistence API) Abstract User Repository Adapter</h1>
 *
 * @param <M> The source type (Model) for mapping.
 * @param <T> The target type (Entity) for mapping.
 *
 * @since 202-
 * @version 1.0
 * @author Q
 */
public abstract class JpaAbstractUserRepositoryAdapter<M extends User, T extends UserEntity>
       extends        JpaCrudRepositoryAdapter<M, T, UUID>
       implements     AbstractUserRepositoryPort<M, UUID> {

    // <<-FIELDS->>
    /**
     * The JPA repository for abstract user entities.
     */
    private final JpaAbstractUserRepository<T> jpaCommonUserRepository;
    /**
     * Mapper for converting between M and T.
     */
    private final MapperServicePort<M, T> mapperService;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaAbstractUserRepositoryAdapter} with the specified {@link JpaAbstractUserRepository}.
     *
     * @param jpaCommonUserRepository The JPA repository for abstract User entities.
     */
    public JpaAbstractUserRepositoryAdapter(JpaAbstractUserRepository<T> jpaCommonUserRepository, MapperServicePort<M, T> mapperService) {
        super(jpaCommonUserRepository, mapperService);
        this.jpaCommonUserRepository = jpaCommonUserRepository;
        this.mapperService           = mapperService;
    }

    // <<-METHODS->>
    @Override
    public Optional<M> findByUsername(String username) {
        return this.jpaCommonUserRepository
                .findByUsername(username)
                .map(this.mapperService::toModel);
    }

    @Override
    public Optional<M> findByEmail(String email) {
        return this.jpaCommonUserRepository
                .findByEmail(email)
                .map(this.mapperService::toModel);
    }

    @Override
    public Optional<UUID> findIdByUsername(String username) {
        return this.jpaCommonUserRepository.findIdByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        this.jpaCommonUserRepository.deleteByUsername(username);
    }

}
