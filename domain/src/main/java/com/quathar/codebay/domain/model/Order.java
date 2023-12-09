package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.type.OrderStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

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
public class Order {

    // <<-FIELDS->>
    private UUID          id;
    private Customer      customer;
    private LocalDateTime date;
    private Set<Detail>   details;
    private BigDecimal    totalPrice;
    private OrderStatus   status;

    /**
     * <h1>Order Detail Model</h1>
     *
     * @since 2023-05-13
     * @version 1.0
     * @author Q
     */
    @Builder
    @Getter
    @Setter
    static class Detail {

        private Product    product;
        private Integer    units;
        private BigDecimal price;

    }

}
