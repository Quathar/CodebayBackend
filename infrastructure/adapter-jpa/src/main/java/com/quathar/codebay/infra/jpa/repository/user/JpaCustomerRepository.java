package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.CustomerEntity;

import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) Customer Repository</h1>
 *
 * @see CustomerEntity
 * @since 2023-05-07
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaCustomerRepository
       extends   CommonJpaUserRepository<CustomerEntity> {
}
