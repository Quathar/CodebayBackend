package com.quathar.codebay.infra.jpa.adapter.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;
import com.quathar.codebay.infra.jpa.entity.CustomerEntity;
import com.quathar.codebay.infra.jpa.mapper.CustomerMapper;
import com.quathar.codebay.infra.jpa.repository.user.JpaCustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
       extends     JpaAbstractUserRepositoryAdapter<Customer, CustomerEntity>
       implements  CustomerRepositoryPort {

    private static final Logger log = LoggerFactory.getLogger(JpaCustomerRepositoryAdapter.class);

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
    public Customer save(Customer customerToCreate) {
        /*
        You may wonder why I don't use the 'save()' default method directly.

        I've tried.

        If you only set the ID of the preexistent User
        then 'IntegrityConstraintViolationException' is thrown since we're
        trying to insert in the 'Users' table and a lot of fields
        cannot be null.

        If we put all the fields of the preexistent User
        then 'DataIntegrityViolationException' is thrown
        as some of the fields are being duplicated.

        This happens because JPA tries to insert in 'User' table in both cases,
        and we DON'T WANT that.

        We only want to insert in 'Customer' table, so the solution here is to create
        a custom Query in the 'JPA Customer Repository'.

        This solution was very PAINFUL.
        */
        CustomerEntity entityToCreate = this.customerMapper.fromModel(customerToCreate);
        int affectedRows = this.jpaCustomerRepository.insertCustomer(entityToCreate);

        log.debug("Affected rows: {}", affectedRows);

        if (affectedRows == 0)
            // TODO: We could use some custom exception here
            throw new RuntimeException();

        return this.jpaCustomerRepository
                .findById(customerToCreate.getId())
                .map(this.customerMapper::toModel)
                .orElseThrow(ModelNotFoundException::new);
    }

}
