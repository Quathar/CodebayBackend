package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.user.AdministratorEntity;

/**
 * <h1>JPA (Java Persistence API) Administrator Repository</h1>
 *
 * @see JpaAbstractUserRepository
 * @see AdministratorEntity
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public interface JpaAdministratorRepository
       extends   JpaAbstractUserRepository<AdministratorEntity> {
}
