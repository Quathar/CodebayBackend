package com.quathar.codebay.infra.jpa.repository.shop;

import com.quathar.codebay.infra.jpa.entity.shop.OrderEntity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <h1>JPA (Java Persistence API) Order Repository</h1>
 *
 * @see OrderEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface JpaOrderRepository extends JpaRepository<OrderEntity, java.util.UUID>  {

    /**
     * Finds all {@link OrderEntity} objects associated with a specific customer's username.
     *
     * @param pageRequest The {@link PageRequest} object containing pagination information.
     * @param username    The username of the customer whose orders are to be retrieved.
     * @return A collection of {@link OrderEntity} objects associated with the specified username.
     */
    @Query("SELECT o FROM OrderEntity o WHERE o.customer.username = :username")
    java.util.Collection<OrderEntity> findAllByUsername(PageRequest pageRequest, String username);

}
