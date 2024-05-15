package com.quathar.codebay.app.service.user;

import com.quathar.codebay.domain.model.Customer;

import lombok.experimental.SuperBuilder;

/**
 * <h1>Customer Service</h1>
 *
 * @see CommonUserService
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class CustomerService
       extends     CommonUserService<Customer> {
}
