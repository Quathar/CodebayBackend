package com.quathar.codebay.infra.outputadapter;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.outputadapter.jpa.entity.UserEntity;
import com.quathar.codebay.infra.outputadapter.jpa.repository.JpaUserRepository;

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
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    // <<-FIELD->>
    private final JpaUserRepository jpaUserRepository;

    // <<-CONSTRUCTOR->>
    @Autowired
    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    // <<-METHODS->>
    @Override
    public Optional<User> findById(UUID uuid) {
        Optional<UserEntity> retrieved = this.jpaUserRepository.findById(uuid);
        // TODO: Mapper from entity to model
        // User user = ...
        return Optional.empty();
    }

    @Override
    public User save(User model) {
        // TODO: Mapper from model to entity
        // UserEntity userEntity = ...
        UserEntity saved = this.jpaUserRepository.save(userEntity);
        // TODO: Mapper from entity to model
        // User user = ...
        return null;
    }

    @Override
    public User update(User model) {
        // TODO: Mapper from model to entity
        // UserEntity userEntity = ...
        UserEntity saved = this.jpaUserRepository.save(userEntity);
        // TODO: Mapper from entity to model
        // User user = ...
        return null;
    }

    @Override
    public boolean deleteById(UUID uuid) {
        if (uuid != null) {
            this.jpaUserRepository.deleteById(uuid);
            return true;
        } else return false;
    }

}
