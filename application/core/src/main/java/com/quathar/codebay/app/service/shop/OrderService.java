package com.quathar.codebay.app.service.shop;

import com.quathar.codebay.app.service.CrudService;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.port.in.shop.order.ReadAllOrdersByUsernameUseCasePort;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * <h1>Order Service</h1>
 *
 * @see CrudService
 * @see ReadAllOrdersByUsernameUseCasePort
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class OrderService
       extends     CrudService<Order, java.util.UUID>
       implements  ReadAllOrdersByUsernameUseCasePort {

    // <<-FIELD->>
    @NonNull private final ReadAllOrdersByUsernameUseCasePort readAllOrdersByUsernameUseCase;

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<Order> getAllOrdersByUsername(String username, int pageIndex, int pageSize) {
        return this.readAllOrdersByUsernameUseCase.getAllOrdersByUsername(username, pageIndex, pageSize);
    }

}
