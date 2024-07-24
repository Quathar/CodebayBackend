package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.UserEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) User Repository</h1>
 *
 * @see UserEntity
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaUserRepository
       extends   JpaAbstractUserRepository<UserEntity> {

    /**
     * Finds a user by their username or email.
     * This method is primarily used for authentication purposes.
     *
     * @param authenticationKey The username or email to search for.
     * @return An Optional containing the UserEntity associated with the provided username or email, if found.
     */
    @Query("SELECT u FROM UserEntity u WHERE u.username = :authenticationKey OR u.email = :authenticationKey")
    java.util.Optional<UserEntity> findByAuthenticationKey(String authenticationKey);

}
