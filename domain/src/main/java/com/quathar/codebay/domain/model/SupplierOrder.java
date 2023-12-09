package com.quathar.codebay.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Supplier Order Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class SupplierOrder {

    // <<-FIELDS->>
    // Basics
    private UUID          id;
    private Supplier      supplier;
    private LocalDateTime date;
    private BigDecimal    untaxedPrice;
    private BigDecimal    taxFee;
    private BigDecimal    total;

}
