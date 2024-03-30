package com.quathar.codebay.infra.jpa.adapter;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.jpa.entity.UserEntity;
import com.quathar.codebay.infra.jpa.mapper.UserMapper;
import com.quathar.codebay.infra.jpa.repository.JpaUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>JPA User Repository Adapter</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaUserRepositoryAdapter
       extends JpaCrudRepositoryAdapter<User, UserEntity, UUID>
       implements UserRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for user entities.
     */
    private final JpaUserRepository jpaUserRepository;
    /**
     * Mapper for converting between User and UserEntity.
     */
    private final UserMapper userMapper;

    // <<-CONSTRUCTOR->>
    @Autowired
    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        super(jpaUserRepository, UserMapper.INSTANCE);
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper        = UserMapper.INSTANCE;
    }

    // <<-METHODS->>
    @Override
    public Optional<User> findByUsername(String username) {
        return this.jpaUserRepository.findByUsername(username).map(this.userMapper::toModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.jpaUserRepository.findByEmail(email).map(this.userMapper::toModel);
    }

    @Override
    public Optional<User> findByAuthenticationKey(String authenticationKey) {
        return this.jpaUserRepository.findByAuthenticationKey(authenticationKey).map(this.userMapper::toModel);
    }

    @Override
    public void deleteByUsername(String username) {
        this.jpaUserRepository.deleteByUsername(username);
    }

}
