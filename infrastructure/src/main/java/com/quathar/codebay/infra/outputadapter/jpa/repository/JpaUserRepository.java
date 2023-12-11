package com.quathar.codebay.infra.outputadapter.jpa.repository;

import com.quathar.codebay.infra.outputadapter.jpa.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <h1>JPA User Repository</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
