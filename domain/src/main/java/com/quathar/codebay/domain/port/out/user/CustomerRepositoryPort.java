package com.quathar.codebay.domain.port.out.user;

import com.quathar.codebay.domain.model.Customer;

/**
 * <h1>Customer Repository Port</h1>
 *
 * Represents a contract for managing customer domain models.
 *
 * @see AbstractUserRepositoryPort
 * @see Customer
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
public interface CustomerRepositoryPort
       extends   AbstractUserRepositoryPort<Customer, java.util.UUID> {
}
