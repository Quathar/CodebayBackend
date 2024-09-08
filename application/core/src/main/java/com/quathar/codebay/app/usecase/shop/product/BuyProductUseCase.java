package com.quathar.codebay.app.usecase.shop.product;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.exception.ProductUnitsOutOfBoundsException;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.OrderDetail;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.port.in.shop.product.BuyProductUseCasePort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.OrderRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Buy product Use Case Implementation</h1>
 *
 * @see BuyProductUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class BuyProductUseCase implements BuyProductUseCasePort {

    // <<-CONSTANT->>
    /**
     * Represents the status of an opened order.
     */
    private static final String OPENED_ORDER_STATUS = "OPEN";

    // <<-FIELDS->>
    /**
     * The product repository port.
     */
    @NonNull
    private final ProductRepositoryPort productRepositoryPort;
    /**
     * The customer repository port.
     */
    @NonNull
    private final CustomerRepositoryPort customerRepositoryPort;
    /**
     * The order repository port.
     */
    @NonNull
    private final OrderRepositoryPort orderRepositoryPort;

    // <<-METHODS->>
    @Override
    public Order buyProduct(String username, String code, int units) {
        // 1. Get customer & product
        Customer customer = this.customerRepositoryPort
                .findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException("Customer NOT FOUND"));
        Product productToBuy = this.productRepositoryPort
                .findByCode(code)
                .orElseThrow(() -> new ModelNotFoundException("Product NOT FOUND"));

        // 2. Check product availability
        if (!productToBuy.isAvailable(units))
            throw new ProductUnitsOutOfBoundsException("Product can't be purchased");

        // 3. Update product & customer information
        java.math.BigDecimal totalPrice = productToBuy.purchase(units);
        Product productUpdated = this.productRepositoryPort.update(productToBuy);

        customer.updateExpenditure(totalPrice);
        Customer customerUpdated = this.customerRepositoryPort.update(customer);

        // 5. Create the order
        var orderDetails = OrderDetail.builder()
                .product(productUpdated)
                .units(units)
                .price(totalPrice)
                .build()
                .stream();
        var order = Order.builder()
                .creationDate(java.time.LocalDateTime.now())
                .status(OPENED_ORDER_STATUS)
                .customer(customerUpdated)
                .details(orderDetails)
                .totalPrice(totalPrice)
                .build();
        return this.orderRepositoryPort.save(order);
    }

}
