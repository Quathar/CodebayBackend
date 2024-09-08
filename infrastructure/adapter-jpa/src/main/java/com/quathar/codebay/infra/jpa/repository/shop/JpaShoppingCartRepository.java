package com.quathar.codebay.infra.jpa.repository.shop;

import com.quathar.codebay.infra.jpa.entity.shop.ShoppingCartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <h1>JPA (Java Persistence API) Shopping Cart Repository</h1>
 *
 * @see ShoppingCartEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface JpaShoppingCartRepository extends JpaRepository<ShoppingCartEntity, java.util.UUID> {

    /**
     * Finds a {@link ShoppingCartEntity} by the associated customer's username.
     *
     * @param username The username of the customer whose shopping cart is to be retrieved.
     * @return An optional containing the {@link ShoppingCartEntity} if found, or empty if not found.
     */
    @Query("SELECT c FROM ShoppingCartEntity c WHERE c.customer.username = :username")
    java.util.Optional<ShoppingCartEntity> findByUsername(String username);

}
