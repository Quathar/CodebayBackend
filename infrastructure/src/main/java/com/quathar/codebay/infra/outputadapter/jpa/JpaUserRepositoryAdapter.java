package com.quathar.codebay.infra.outputadapter.jpa;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.outputadapter.jpa.entity.UserEntity;
import com.quathar.codebay.infra.outputadapter.jpa.mapper.UserMapper;
import com.quathar.codebay.infra.outputadapter.jpa.repository.JpaUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * <h1>JPA User Repository Adapter</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Component
public class JpaUserRepositoryAdapter extends JpaRepositoryAdapter<User, UserEntity, UUID> implements UserRepositoryPort {

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
        super(jpaUserRepository, UserMapper.getInstance());
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper        = UserMapper.getInstance();
    }

}
