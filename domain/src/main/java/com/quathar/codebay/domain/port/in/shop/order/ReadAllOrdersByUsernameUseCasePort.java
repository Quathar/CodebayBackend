package com.quathar.codebay.domain.port.in.shop.order;

import com.quathar.codebay.domain.model.shop.Order;

/**
 * <h1>Read all orders by username Use Case Port</h1>
 *
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface ReadAllOrdersByUsernameUseCasePort {

    /**
     * Retrieves all orders associated with the specified username, with pagination support.
     *
     * @param username  The username of the customer
     * @param pageIndex The page index
     * @param pageSize  The number of items per page
     * @return A stream of orders for the specified username, within the specified page index and size
     */
    java.util.stream.Stream<Order> getAllOrdersByUsername(String username, int pageIndex, int pageSize);

}
