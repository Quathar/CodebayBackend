package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;
import com.quathar.codebay.infra.jpa.entity.user.UserEntity;
import com.quathar.codebay.infra.jpa.mapper.user.UserMapper;
import com.quathar.codebay.infra.jpa.repository.user.JpaUserRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA User Repository Adapter</h1>
 *
 * @see UserRepositoryPort
 * @see User
 * @see UserEntity
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaUserRepositoryAdapter
       extends     JpaAbstractUserRepositoryAdapter<User, UserEntity>
       implements  UserRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for user entities.
     */
    private final JpaUserRepository jpaUserRepository;
    /**
     * Mapper for converting between {@link User} and {@link UserEntity}.
     */
    private final UserMapper userMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaUserRepositoryAdapter} for the {@link UserRepositoryPort}
     * with the specified {@link JpaUserRepository} and {@link UserMapper}.
     *
     * @param jpaUserRepository The JPA repository for {@link UserEntity}.
     * @param userMapper        The mapper for converting between {@link User} and {@link UserEntity}.
     */
    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        super(jpaUserRepository, userMapper);
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper        = userMapper;
    }

    // <<-METHODS->>
    @Override
    public java.util.Optional<User> findByAuthenticationKey(String authenticationKey) {
        return this.jpaUserRepository
                .findByAuthenticationKey(authenticationKey)
                .map(this.userMapper::toModel);
    }

    /**
     * Updates the {@link UserEntity} identified by the given username using the provided updater function.
     *
     * @param username The username of the user whose entity needs to be updated.
     * @param updater  A {@link java.util.function.Consumer} that takes a {@link UserEntity} and performs updates on it.
     */
    private void updateEntity(String username, java.util.function.Consumer<UserEntity> updater) {
        this.jpaUserRepository
                .findByUsername(username)
                .ifPresent(userEntity -> {
                    updater.accept(userEntity);
                    this.jpaUserRepository.save(userEntity);
                });
    }

    @Override
    public void incrementSuccessfulAuth(String username) {
        this.updateEntity(username,
                (userEntity) -> userEntity.setSuccessfulAuth( userEntity.getSuccessfulAuth() + 1 )
        );
    }

    @Override
    public void incrementFailedAuth(String username) {
        this.updateEntity(username,
                (userEntity) -> userEntity.setFailedAuth( userEntity.getFailedAuth() + 1 )
        );
    }

}
