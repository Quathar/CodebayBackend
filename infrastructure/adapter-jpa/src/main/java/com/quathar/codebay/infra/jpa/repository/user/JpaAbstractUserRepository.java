package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>JPA (Java Persistence API) Abstract User Repository</h1>
 *
 * @param <T> The type of entity this repository manages.
 *
 * @see JpaRepository
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface JpaAbstractUserRepository<T extends UserEntity>
       extends   JpaRepository<T, UUID> {

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return An {@link Optional} containing the {@link UserEntity} associated with the provided username, if found.
     */
    Optional<T> findByUsername(String username);

    /**
     * Finds a user by their email.
     *
     * @param email The email to search for.
     * @return An {@link Optional} containing the {@link UserEntity} associated with the provided email, if found.
     */
    Optional<T> findByEmail(String email);

    /**
     * Finds the ID of a user by their username.
     *
     * @param username The username to search for.
     * @return An {@link Optional} containing the {@link UUID} associated with the provided username, if found.
     */
    @Query("SELECT u.id FROM UserEntity u WHERE u.username = :username")
    Optional<UUID> findIdByUsername(@Param("username") String username);

    /**
     * Deletes a user by their username.
     *
     * @param username The username of the user to delete.
     */
    void deleteByUsername(String username);

}
