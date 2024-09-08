package com.quathar.codebay.domain.port.out.shop;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

/**
 * <h1>Order Repository Port</h1>
 *
 * @see CrudRepositoryPort
 * @see Order
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface OrderRepositoryPort
       extends   CrudRepositoryPort<Order, java.util.UUID> {

    /**
     * Retrieves all orders associated with the specified username, with pagination support.
     *
     * @param username  The username of the customer
     * @param pageIndex The page index
     * @param pageSize  The number of items per page
     * @return A stream of orders for the specified username, limited by the specified page index and size
     */
    java.util.stream.Stream<Order> findAllByUsername(String username, int pageIndex, int pageSize);

}
