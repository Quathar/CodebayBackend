package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.valueobject.Audit;
import com.quathar.codebay.domain.valueobject.shop.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Product Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class Product {

    // <<-FIELDS->>
    private UUID          id;
    private String        code;
    private String        name;
    private String        description;
    private String        brand;
    private String        model;
    private Stream<Image> productImages;
    private BigDecimal    price;
    private Integer       ratingNumber;
    private BigDecimal    rating;
    private Integer       stock;
    private Integer       unitsSold;
    private Integer       upperLimit;    // At this limit, a warning will appear
    private Integer       lowerLimit;    // At this limit, the product will no longer be offered
    private BigDecimal    totalEarnings; // Total money earned selling this product
    private Boolean       onSale;
    private Boolean       onOffer;
    private Boolean       isNew;
    private BigDecimal    discount;
    private String        comments;
    private Audit         audit;

    // <<-METHODS->>
    /**
     * Checks if the specified number of units is available for purchase.
     *
     * @param unitsToBuy The number of units to check availability for
     * @return {@code true} if the specified number of units is available for purchase, otherwise {@code false}
     */
    public boolean isAvailable(int unitsToBuy) {
        return this.onSale
               && this.stock > this.lowerLimit  // Has not reached lower limit
               && this.stock - unitsToBuy >= 0; // All units can be purchased
    }

    /**
     * Checks if the stock is on the lower limit.
     *
     * @return {@code true} if the stock is on or below the lower limit, otherwise {@code false}
     */
    private boolean isOnLowerLimit() {
        return this.stock <= this.lowerLimit;
    }

    /**
     * Checks if the stock is on the upper limit.
     *
     * @return {@code true} if the stock is on or below the upper limit, otherwise {@code false}
     */
    private boolean isOnUpperLimit() {
        return this.stock <= this.upperLimit;
    }

    /**
     * Updates the stock.
     *
     * @param units The number of units to subtract from the stock
     */
    private void updateStock(int units) {
        this.stock -= units;
    }

    /**
     * Updates the units sold.
     *
     * @param units The number of units to add to the units sold
     */
    private void updateUnitsSold(int units) {
        this.unitsSold += units;
    }

    /**
     * Updates the total earnings.
     *
     * @param earnings The earnings to add to the total earnings
     */
    private void updateEarnings(BigDecimal earnings) {
        this.totalEarnings = this.totalEarnings.add(earnings);
    }

    /**
     * Updates the product information after a purchase.
     *
     * @param units The number of units purchased
     * @return The total price of the purchase
     */
    public BigDecimal purchase(int units) {
        this.updateStock(units);
        this.updateUnitsSold(units);
        var totalPrice = this.price.multiply(BigDecimal.valueOf(units));
        this.updateEarnings(totalPrice);

        if (this.isOnLowerLimit())
            // TODO: Publish event
            throw new RuntimeException();
        if (this.isOnUpperLimit())
            // TODO: Publish event
            throw new RuntimeException();
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
