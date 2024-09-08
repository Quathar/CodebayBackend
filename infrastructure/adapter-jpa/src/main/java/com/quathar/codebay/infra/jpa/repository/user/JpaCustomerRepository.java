package com.quathar.codebay.infra.jpa.repository.user;

import com.quathar.codebay.infra.jpa.entity.user.CustomerEntity;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <h1>JPA (Java Persistence API) Customer Repository</h1>
 *
 * @see JpaAbstractUserRepository
 * @see CustomerEntity
 * @since 2023-05-07
 * @version 1.0
 * @author Q
 */
public interface JpaCustomerRepository
       extends   JpaAbstractUserRepository<CustomerEntity> {

    /**
     * Doc later
     *
     * @param documentContent
     * @return
     */
    boolean existsByPersonalInfoDocumentContent(String documentContent);

    /**
     * Inserts a new customer record into the Customer table.
     *
     * @param customer The {@link CustomerEntity} containing all the necessary information to be inserted.
     * @return The number of rows affected by the insert operation.
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = """
        INSERT INTO Customer(
            user_id,
            document_type, document,
            name, surnames, gender, birthdate,
            phone_code, phone_number,
            country, road_type, address_name, address_number, portal,
            floor, location, region, postal_code,
            accumulated_expenditure, type, license,
            comments
        )
        VALUES (
            :#{#customer.id},
            :#{#customer.personalInfo.document.type}, :#{#customer.personalInfo.document.content},
            :#{#customer.personalInfo.name}, :#{#customer.personalInfo.surnames}, :#{#customer.personalInfo.gender}, :#{#customer.personalInfo.birthdate},
            :#{#customer.personalInfo.phone.countryCode}, :#{#customer.personalInfo.phone.number},
            :#{#customer.country}, :#{#customer.homeAddress.roadType}, :#{#customer.homeAddress.name}, :#{#customer.homeAddress.number}, :#{#customer.homeAddress.portal},
            :#{#customer.homeAddress.floor}, :#{#customer.homeAddress.location}, :#{#customer.homeAddress.region}, :#{#customer.homeAddress.postalCode},
            :#{#customer.accumulatedExpenditure}, :#{#customer.type}, :#{#customer.license},
            :#{#customer.comments}
        );
    """)
    int insertCustomer(@Param("customer") CustomerEntity customer);

}
