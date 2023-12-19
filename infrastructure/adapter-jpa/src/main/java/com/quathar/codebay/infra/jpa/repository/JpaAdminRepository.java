package com.quathar.codebay.infra.jpa.repository;

import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>JPA Administrator Repository</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaAdminRepository extends JpaRepository<AdministratorEntity, UUID> {

    /**
     * Finds an admin by their username.
     *
     * @param username The username to search for.
     * @return An Optional containing the AdministratorEntity associated with the provided username, if found.
     */
    Optional<AdministratorEntity> findByUsername(String username);

    /**
     * Finds an admin by their email.
     *
     * @param email The email to search for.
     * @return An Optional containing the AdministratorEntity associated with the provided email, if found.
     */
    Optional<AdministratorEntity> findByEmail(String email);

}
