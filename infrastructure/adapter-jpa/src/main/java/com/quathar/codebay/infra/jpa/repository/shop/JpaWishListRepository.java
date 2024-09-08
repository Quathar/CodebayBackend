package com.quathar.codebay.infra.jpa.repository.shop;

import com.quathar.codebay.infra.jpa.entity.shop.WishListEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <h1>JPA (Java Persistence API) Wish List Repository</h1>
 *
 * @see WishListEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface JpaWishListRepository extends JpaRepository<WishListEntity, java.util.UUID> {

    /**
     * Finds a {@link WishListEntity} by the associated customer's username.
     *
     * @param username The username of the customer whose wish list is to be retrieved.
     * @return An optional containing the {@link WishListEntity} if found, or empty if not found.
     */
    @Query("SELECT w FROM WishListEntity w WHERE w.customer.username = :username")
    java.util.Optional<WishListEntity> findByUsername(String username);

}
