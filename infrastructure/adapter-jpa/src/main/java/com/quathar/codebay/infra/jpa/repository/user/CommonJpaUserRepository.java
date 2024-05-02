package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <h1>Common JPA (Java Persistence API) User Repository</h1>
 *
 * @param <T> The type of entity this repository manages.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface CommonJpaUserRepository<T extends UserEntity>
       extends   JpaRepository<T, java.util.UUID> {

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return An Optional containing the UserEntity associated with the provided username, if found.
     */
    Optional<T> findByUsername(String username);

    /**
     * Finds a user by their email.
     *
     * @param email The email to search for.
     * @return An Optional containing the UserEntity associated with the provided email, if found.
     */
    Optional<T> findByEmail(String email);

    /**
     * Deletes a user by their username.
     *
     * @param username The username of the user to delete.
     */
    void deleteByUsername(String username);

}
