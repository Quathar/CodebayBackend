package com.quathar.codebay.app.usecase.shop.order;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.port.in.shop.order.ReadAllOrdersByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.shop.OrderRepositoryPort;

import lombok.AllArgsConstructor;

/**
 * <h1>Read All Orders by Username Use Case Implementation</h1>
 *
 * @see ReadAllOrdersByUsernameUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public class ReadAllOrdersByUsernameUseCase implements ReadAllOrdersByUsernameUseCasePort {

    // <<-FIELD->>
    /**
     * The order repository port.
     */
    private final OrderRepositoryPort orderRepositoryPort;

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<Order> getAllOrdersByUsername(String username, int pageIndex, int pageSize) {
        return this.orderRepositoryPort.findAllByUsername(username, pageIndex, pageSize);
    }

}
