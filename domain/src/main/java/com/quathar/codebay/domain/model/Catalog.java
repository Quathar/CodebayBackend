package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Period;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Catalog Model</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Catalog {

    // <<-FIELDS->>
    private UUID        id;
    private Supplier    supplier;
    private Period      period;
    private Set<Detail> details;

    /**
     * <h1>Catalog Detail Model</h1>
     *
     * @since 2023-05-13
     * @version 2.0
     * @author Q
     */
    @Builder
    @Getter
    @Setter
    static class Detail {

        // <<-FIELDS->>
        private Product    product;
        private BigDecimal price;

    }

}
