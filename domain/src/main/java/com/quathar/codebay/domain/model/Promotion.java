package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.Period;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Promotion Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Promotion {

    // <<-FIELDS->>
    private UUID         id;
    private String       name;
    private String       description;
    private Period       period;
    private BigDecimal   discount;
    private Audit        audit;
    private Set<Product> products;

}
