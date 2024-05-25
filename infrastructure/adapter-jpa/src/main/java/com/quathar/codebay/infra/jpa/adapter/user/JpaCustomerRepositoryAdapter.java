package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.CustomerEntity;
import com.quathar.codebay.infra.jpa.mapper.CustomerMapper;
import com.quathar.codebay.infra.jpa.repository.user.JpaCustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * <h1>JPA Customer Repository Adapter</h1>
 *
 * @see CustomerRepositoryPort
 * @see Customer
 * @see CustomerEntity
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaCustomerRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<Customer, CustomerEntity, java.util.UUID>
       implements  CustomerRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for admin entities.
     */
    private final JpaCustomerRepository jpaCustomerRepository;
    /**
     * Mapper for converting between Administrator and AdministratorEntity.
     */
    private final CustomerMapper customerMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaAdministratorRepositoryAdapter} with the specified JpaAdministratorRepository.
     *
     * @param jpaCustomerRepository The JPA repository for Administrator entities.
     */
    @Autowired
    public JpaCustomerRepositoryAdapter(JpaCustomerRepository jpaCustomerRepository, CustomerMapper customerMapper) {
        super(jpaCustomerRepository, customerMapper);
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerMapper        = customerMapper;
    }

    // <<-METHODS->>
    @Override
    public Optional<Customer> findByUsername(String username) {
        return this.jpaCustomerRepository
                .findByUsername(username)
                .map(this.customerMapper::toModel);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return this.jpaCustomerRepository
                .findByEmail(email)
                .map(this.customerMapper::toModel);
    }

    @Override
    public void deleteByUsername(String username) {
        this.jpaCustomerRepository.deleteByUsername(username);
    }

}
