package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.model.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Wish List Model</h1>
 *
 * @since 2024-05-07
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class WishList {

    // <<-FIELDS->>
    private UUID            id;
    private Customer        customer;
    private Stream<Product> products;

    // <<-METHODS->>
    /**
     *
     * @return
     */
    public Stream<Product> copyProducts() {
        var productList = this.products.toList();
        this.products = productList.stream();
        return productList.stream();
    }

    /**
     *
     * @param productToCheck
     * @return
     */
    public boolean hasProduct(Product productToCheck) {
        return this.copyProducts().anyMatch(product -> product.equals(productToCheck));
    }

    /**
     * Adds a product to the wish list.
     *
     * @param productToAdd The product to add
     */
    public void addProduct(Product productToAdd) {
        // We're not using this, but here is another way to merge streams
        // U can investigate what's better
        // But I think this will be okay
        // since there isn't a lot of calls to this method at once
        // Stream.of( this.products, Stream.of(productToAdd) ).flatMap(s -> s);
        this.products = Stream.concat( this.products, Stream.of(productToAdd) );
    }

    /**
     * Removes a product from the wish list.
     *
     * @param productToRemove The product to remove
     */
    public void removeProduct(Product productToRemove) {
        this.products = this.products.filter(product -> !product.equals(productToRemove));
    }

}
