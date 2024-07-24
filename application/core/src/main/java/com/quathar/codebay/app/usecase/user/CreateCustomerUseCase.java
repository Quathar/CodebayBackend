package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.in.CreateModelUseCasePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import static java.math.BigDecimal.ZERO;

/**
 * <h1>Create Customer Use Case Implementation</h1>
 *
 * @see CreateModelUseCasePort
 * @see Customer
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class CreateCustomerUseCase implements CreateModelUseCasePort<Customer> {

    // <<-CONSTANTS->>
    /**
     * The default type for newly created customers.
     */
    private static final String BRONZE_CUSTOMER_TYPE = "BRZ";
    /**
     * Default role for customers.
     */
    private static final String CUSTOMER_ROLE = "CUSTOMER";

    // <<-FIELD->>
    /**
     * The customer repository port.
     */
    @NonNull
    private final CustomerRepositoryPort customerRepositoryPort;
    /**
     * The shopping cart repository port.
     */
    @NonNull
    private final ShoppingCartRepositoryPort cartRepositoryPort;
    /**
     * The wish list repository port.
     */
    @NonNull
    private final WishListRepositoryPort wishListRepositoryPort;
    /**
     * The role repository port.
     */
    @NonNull
    private final RoleRepositoryPort roleRepositoryPort;

    // <<-METHODS->>
    /**
     * Initializes a customer by setting default values.
     *
     * @param customerToInit The {@link Customer} to initialize
     * @return The initialized {@link Customer}
     */
    private Customer initCustomer(Customer customerToInit) {
        java.util.UUID id = this.customerRepositoryPort
                .findIdByUsername(customerToInit.getUsername())
                .orElseThrow();

        customerToInit.setId( id );
        customerToInit.setLastConnection( java.time.LocalDateTime.now() );
        customerToInit.setType( BRONZE_CUSTOMER_TYPE );
        customerToInit.setAccumulatedExpenditure( ZERO );

        return customerToInit;
    }

    /**
     * Creates the necessary resources for a customer, such as a shopping cart and a wish list.
     *
     * @param customer The {@link Customer} for whom to create resources
     * @return The {@link Customer} with the created resources
     */
    private Customer createCustomerResources(Customer customer) {
        // 1. Create the Shopping Cart for the Customer
        var cartToCreate = ShoppingCart.builder()
                .customer(customer)
                .build();
        var updatedCustomer = this.cartRepositoryPort
                .save(cartToCreate)
                .getCustomer();

        // 2. Create the Wish List for the Customer
        var wishListToCreate = WishList.builder()
                .customer(updatedCustomer)
                .build();
        return this.wishListRepositoryPort
                .save(wishListToCreate)
                .getCustomer();
    }

    @Override
    public Customer create(Customer customerToCreate) {
        // 1. Initialize and insert the customer information
        Customer initialized = this.initCustomer(customerToCreate);
        Customer createdCustomer = this.customerRepositoryPort.save(initialized);

        // 2. Create Shopping Cart and Wish List for the new Customer
        Customer completeCustomer = this.createCustomerResources(createdCustomer);

        // 3. Update the Role from 'USER' to 'CUSTOMER'
        Role role = this.roleRepositoryPort
                .findByName(CUSTOMER_ROLE)
                .orElseThrow(ModelNotFoundException::new);
        completeCustomer.setRole(role);
        return this.customerRepositoryPort.update(completeCustomer);
    }

}
