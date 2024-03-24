package com.quathar.codebay.infra.jpa.repository.security;

import com.quathar.codebay.infra.jpa.entity.security.OperationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) Operation Repository</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaOperationRepository extends JpaRepository<OperationEntity, java.util.UUID> {

    /**
     * Finds an operation entity by its name.
     *
     * @param operationName The name of the operation entity to find.
     * @return An Optional containing the found operation entity, or empty if not found.
     */
    java.util.Optional<OperationEntity> findByName(String operationName);

}
