package com.quathar.codebay.domain.model.type;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * <h1>Customer Type</h1>
 *
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@SuperBuilder
@Getter
@Setter
public class CustomerType extends BaseType {

    // <<-FIELDS->>
    private BigDecimal discount;    // [0%, 5%, 10%, 20%]
    private BigDecimal lowerLimit;  // [0€, 100€, 200€, 350€] (the customers are always Bronze)

}
