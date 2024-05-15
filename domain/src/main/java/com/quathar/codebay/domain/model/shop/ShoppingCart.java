package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.model.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.stream.Stream;

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
public final class ShoppingCart {

    // <<-FIELDS->>
    private UUID               id;
    private Customer           customer;
    private Stream<CartDetail> details;

    // <<-METHODS->>
    /**
     * Clones the details of the shopping cart.
     *
     * @return A stream of cloned cart details
     */
    public Stream<CartDetail> cloneDetails() {
        var detailsList = this.details.toList();
        this.details = detailsList.stream();
        return detailsList.stream();
    }

    /**
     * Checks if the shopping cart contains the specified product.
     *
     * @param productToCheck The product to check
     * @return {@code true} if the shopping cart contains the specified product, otherwise {@code false}
     */
    public boolean hasProduct(Product productToCheck) {
        return this.cloneDetails()
                .map(CartDetail::getProduct)
                .anyMatch(product -> product.equals(productToCheck));
    }

    /**
     * Adds a product with specified units to the shopping cart.
     *
     * @param product The product to add
     * @param units   The number of units of the product to add
     */
    public void addProduct(Product product, int units) {
        var cartDetail = CartDetail.builder()
                .product(product)
                .units(units)
                .build();
        this.details = Stream.concat( this.details, Stream.of(cartDetail) );
    }

    /**
     * Updates the units of a product in the shopping cart.
     *
     * @param product The product to update
     * @param units   The new number of units for the product
     */
    public void updateProductUnits(Product product, int units) {
        this.details = this.details
                .map(cartDetail -> {
                    if (!cartDetail.getProduct().equals(product))
                        return cartDetail;
                    cartDetail.setUnits(units);
                    return cartDetail;
                });
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product The product to remove
     */
    public void removeProduct(Product product) {
        this.details = this.details.filter(cartDetail -> !cartDetail.getProduct().equals(product));
    }

}
