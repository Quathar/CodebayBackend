package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;

import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) Administrator Repository</h1>
 *
 * @see AdministratorEntity
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaAdministratorRepository
       extends   JpaAbstractUserRepository<AdministratorEntity> {
}
