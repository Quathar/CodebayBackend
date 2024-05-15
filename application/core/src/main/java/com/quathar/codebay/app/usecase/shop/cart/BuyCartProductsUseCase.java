package com.quathar.codebay.app.usecase.shop.cart;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.model.shop.CartDetail;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.OrderDetail;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.in.shop.cart.BuyCartProductsUseCasePort;
import com.quathar.codebay.domain.port.out.shop.OrderRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

/**
 * <h1>Buy cart products Use Case Implementation</h1>
 *
 * @see BuyCartProductsUseCasePort
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class BuyCartProductsUseCase implements BuyCartProductsUseCasePort {

    // <<-CONSTANT->>
    /**
     * Represents the status of an opened order.
     */
    private static final String OPENED_ORDER_STATUS = "OPEN";

    // <<-FIELDS->>
    /**
     * The order repository port.
     */
    @NonNull
    private final ShoppingCartRepositoryPort cartRepositoryPort;
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
    /**
     * Checks if the product in the cart detail is available for purchase.
     *
     * @param cartDetail The cart detail to check for product availability
     * @return {@code true} if the product is available for purchase, {@code false} otherwise
     */
    private boolean availableProducts(CartDetail cartDetail) {
        int unitsToBuy = cartDetail.getUnits();
        return cartDetail.getProduct().isAvailable(unitsToBuy);
    }

    /**
     * Creates an order detail from a cart detail.
     *
     * @param cartDetail The cart detail to create the order detail from
     * @return The order detail created from the cart detail
     */
    private OrderDetail createOrderDetail(CartDetail cartDetail) {
        // 1. Update product info
        var product = cartDetail.getProduct();
        int units   = cartDetail.getUnits();
        var price   = product.purchase(units);
        var productUpdated = this.productRepositoryPort.save(product);

        // 2. Create order detail
        return OrderDetail.builder()
                .product(productUpdated)
                .units(units)
                .price(price)
                .build();
    }

    /**
     * Updates the customer and shopping cart.
     *
     * @param cart         The shopping cart containing the purchased products
     * @param totalPrice   The total price of the purchased products
     * @param orderDetails The collection of order details for the purchased products
     * @return The updated customer after updating the information
     */
    private Customer updateCartAndGetCustomer(ShoppingCart cart, BigDecimal totalPrice, java.util.Collection<OrderDetail> orderDetails) {
        // 1. Update the Customer
        var customer = cart.getCustomer();
        customer.updateExpenditure(totalPrice);
        var updatedCustomer = this.customerRepositoryPort.save(customer);

        // 2. Set the updated Customer in the ShoppingCart
        // This is done to avoid future java.util.Stream problems
        // since some streams were consumed when save() method was invoked
        cart.setCustomer(updatedCustomer);

        // 3. Remove all purchased products
        orderDetails.stream()
                .map(OrderDetail::getProduct)
                .forEach(cart::removeProduct);

        // 4. Return the customer from the updated ShoppingCart
        return this.cartRepositoryPort
                .save(cart)
                .getCustomer();
    }

    /**
     * Processes the order based on the products in the shopping cart.
     *
     * @param cart The shopping cart containing the products to process the order for
     * @return A collector to accumulate and process the order details into an order object
     */
    private java.util.stream.Collector<OrderDetail, ?, Order> processOrder(ShoppingCart cart) {
        return collectingAndThen(
                toSet(),
                orderDetailsSet -> {
                    var totalPrice = orderDetailsSet.stream()
                            .map(OrderDetail::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    var customer = this.updateCartAndGetCustomer(cart, totalPrice, orderDetailsSet);
                    return Order.builder()
                            .creationDate(java.time.LocalDateTime.now())
                            .status(OPENED_ORDER_STATUS)
                            .customer(customer)
                            .details(orderDetailsSet.stream())
                            .totalPrice(totalPrice)
                            .build();
                }
        );
    }

    @Override
    public Order buyCartProducts(String username) {
        ShoppingCart cart = this.cartRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
        Order order = cart.cloneDetails()
                .filter(this::availableProducts)
                .map(this::createOrderDetail)
                .collect(this.processOrder(cart));
        return this.orderRepositoryPort.save(order);
    }

}
