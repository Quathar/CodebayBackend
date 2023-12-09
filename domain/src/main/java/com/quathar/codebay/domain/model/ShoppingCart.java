package com.quathar.codebay.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Shopping Cart Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class ShoppingCart {

    // <<-FIELDS->>
    private UUID          id;
    private Customer      customer;
    private LocalDateTime creationDate;
    private Set<Detail>   details;
    private BigDecimal    price;

    /**
     * <h1>Shopping Cart Detail Model</h1>
     *
     * @since 2023-05-13
     * @version 2.0
     * @author Q
     */
    @Builder
    @Getter
    @Setter
    static class Detail {

        private Product product;
        private Integer units;

    }

}
