package com.quathar.codebay.domain.model.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

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
public final class CartDetail {

    // <<-FIELDS->>
    private Product product;
    private Integer units;

    // <<-METHOD->>
    /**
     * Returns a sequential {@code Stream} containing only this cart detail.
     *
     * @return A sequential {@code Stream} containing only this cart detail
     */
    public Stream<CartDetail> stream() {
        return Stream.of(this);
    }

}
