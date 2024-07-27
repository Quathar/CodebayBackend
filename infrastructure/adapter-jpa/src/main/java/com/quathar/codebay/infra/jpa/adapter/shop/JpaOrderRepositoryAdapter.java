package com.quathar.codebay.infra.jpa.adapter.shop;

import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.port.out.shop.OrderRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.shop.OrderEntity;
import com.quathar.codebay.infra.jpa.mapper.shop.OrderMapper;
import com.quathar.codebay.infra.jpa.repository.shop.JpaOrderRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Order Repository Adapter</h1>
 *
 * @see OrderRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see Order
 * @see OrderEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaOrderRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<Order, OrderEntity, java.util.UUID>
       implements  OrderRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for {@link OrderEntity}.
     */
    private final JpaOrderRepository jpaOrderRepository;
    /**
     * Mapper for converting between {@link Order} and {@link OrderEntity}.
     */
    private final OrderMapper orderMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaOrderRepositoryAdapter} for the {@link OrderRepositoryPort}
     * with the specified {@link JpaOrderRepository} and {@link OrderMapper}.
     *
     * @param jpaOrderRepository The JPA repository for {@link OrderEntity}.
     * @param orderMapper        The mapper for converting between {@link Order} and {@link OrderEntity}.
     */
    public JpaOrderRepositoryAdapter(JpaOrderRepository jpaOrderRepository, OrderMapper orderMapper) {
        super(jpaOrderRepository, orderMapper);
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderMapper        = orderMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<Order> findAllByUsername(String username, int pageIndex, int pageSize) {
        var pageRequest = PageRequest.of(pageIndex, pageSize);
        return this.jpaOrderRepository
                .findAllByUsername(pageRequest, username)
                .stream()
                .map(this.orderMapper::toModel);
    }

}
