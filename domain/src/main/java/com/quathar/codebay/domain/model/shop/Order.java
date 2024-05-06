package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.model.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Order Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class Order {

    // <<-FIELDS->>
    private UUID                id;
    private Customer            customer;
    private LocalDateTime       date;
    private Stream<OrderDetail> details;
    private BigDecimal          totalPrice;
    private String              status;

}
