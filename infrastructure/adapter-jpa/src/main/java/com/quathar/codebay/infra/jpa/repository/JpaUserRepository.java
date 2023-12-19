package com.quathar.codebay.infra.jpa.repository;

import com.quathar.codebay.infra.jpa.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
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

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return An Optional containing the UserEntity associated with the provided username, if found.
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Finds a user by their email.
     *
     * @param email The email to search for.
     * @return An Optional containing the UserEntity associated with the provided email, if found.
     */
    Optional<UserEntity> findByEmail(String email);

}
