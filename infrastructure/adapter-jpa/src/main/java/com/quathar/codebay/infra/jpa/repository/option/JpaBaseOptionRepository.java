package com.quathar.codebay.infra.jpa.repository.option;

import com.quathar.codebay.infra.jpa.entity.option.BaseOptionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>JPA (Java Persistence API) Base Option Repository</h1>
 *
 * @param <T> The type of entity this repository manages.
 *
 * @see JpaRepository
 * @see BaseOptionEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
public interface JpaBaseOptionRepository<T extends BaseOptionEntity>
       extends   JpaRepository<T, String> {
}
