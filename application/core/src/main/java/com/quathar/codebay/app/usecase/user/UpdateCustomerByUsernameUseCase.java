package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.in.user.UpdateByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;
import com.quathar.codebay.domain.valueobject.PersonalInfo;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

/**
 * <h1>Update Customer by Username Use Case Implementation</h1>
 *
 * @see UpdateByUsernameUseCasePort
 * @see Customer
 * @since 2024-05-05
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class UpdateCustomerByUsernameUseCase implements UpdateByUsernameUseCasePort<Customer> {

    // <<-FIELD->>
    /**
     * The customer repository port.
     */
    @NonNull
    private final CustomerRepositoryPort customerRepositoryPort;

    // <<-METHOD->>
    @Override
    public Customer updateByUsername(Customer customerToUpdate) {
        Customer retrievedCustomer = this.customerRepositoryPort
                .findByUsername(customerToUpdate.getUsername())
                .orElseThrow(ModelNotFoundException::new);

        // Personal info
        PersonalInfo savedPersonalInfo = retrievedCustomer.getPersonalInfo();
        PersonalInfo newPersonalInfo   = customerToUpdate.getPersonalInfo();
        if (newPersonalInfo != null) {
            Optional.ofNullable(newPersonalInfo.getName())
                    .ifPresent(savedPersonalInfo::setName);
            Optional.ofNullable(newPersonalInfo.getSurnames())
                    .ifPresent(savedPersonalInfo::setSurnames);
            Optional.ofNullable(newPersonalInfo.getGender())
                    .ifPresent(savedPersonalInfo::setGender);
            Optional.ofNullable(newPersonalInfo.getBirthdate())
                    .ifPresent(savedPersonalInfo::setBirthdate);
        }

        // TODO: Other updatable fields...

        return this.customerRepositoryPort.update(retrievedCustomer);
    }

}
