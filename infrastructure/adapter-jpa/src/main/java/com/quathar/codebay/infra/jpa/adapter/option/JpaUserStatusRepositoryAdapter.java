package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.UserStatusRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.UserStatus;
import com.quathar.codebay.infra.jpa.entity.option.UserStatusEntity;
import com.quathar.codebay.infra.jpa.mapper.option.UserStatusMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaUserStatusRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) User Status Repository Adapter</h1>
 *
 * @see UserStatusRepositoryPort
 * @see JpaBaseOptionRepositoryAdapter
 * @see UserStatus
 * @see UserStatusEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaUserStatusRepositoryAdapter
       extends     JpaBaseOptionRepositoryAdapter<UserStatus, UserStatusEntity>
       implements  UserStatusRepositoryPort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaUserStatusRepositoryAdapter} for the {@link UserStatusRepositoryPort}
     * with the specified {@link JpaUserStatusRepository} and {@link UserStatusMapper}.
     *
     * @param jpaUserStatusRepository The JPA repository for {@link UserStatusEntity}.
     * @param userStatusMapper        The mapper for converting between {@link UserStatus} and {@link UserStatusEntity}.
     */
    public JpaUserStatusRepositoryAdapter(JpaUserStatusRepository jpaUserStatusRepository, UserStatusMapper userStatusMapper) {
        super(jpaUserStatusRepository, userStatusMapper);
    }

}
