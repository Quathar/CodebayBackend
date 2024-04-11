package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Customer Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class CustomerTests {

    // <<-FIELD->>
    private Customer mock;

    // <<-TEST->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Customer.class);
    }

//    @Test
//    void fullArgsConstructorTest() {
//        Customer customer = new Customer(
//                this.mock.getId(),
////                this.mock.getUser(),
////                this.mock.getDocumentType(),
////                this.mock.getDocument(),
////                this.mock.getName(),
////                this.mock.getSurnames(),
////                this.mock.getGender(),
////                this.mock.getBirthdate(),
//                this.mock.getCountry(),
////                this.mock.getPhoneNumber(),
//                this.mock.getHomeAddress(),
//                this.mock.getAddresses(),
//                this.mock.getBankCards(),
//                this.mock.getAccumulatedExpenditure(),
//                this.mock.getType(),
//                this.mock.getComments(),
//                this.mock.getLicense(),
//                this.mock.getAudit()
//        );
//
//        assertThat( customer.getId()                     ).isEqualTo( this.mock.getId() );
////        assertThat( customer.getUser()                   ).isEqualTo( this.mock.getUser() );
////        assertThat( customer.getDocumentType()           ).isEqualTo( this.mock.getDocumentType() );
////        assertThat( customer.getDocument()               ).isEqualTo( this.mock.getDocument() );
////        assertThat( customer.getName()                   ).isEqualTo( this.mock.getName() );
////        assertThat( customer.getSurnames()               ).isEqualTo( this.mock.getSurnames() );
////        assertThat( customer.getGender()                 ).isEqualTo( this.mock.getGender() );
////        assertThat( customer.getBirthdate()              ).isEqualTo( this.mock.getBirthdate() );
//        assertThat( customer.getCountry()                ).isEqualTo( this.mock.getCountry() );
////        assertThat( customer.getPhoneNumber()            ).isEqualTo( this.mock.getPhoneNumber() );
//        assertThat( customer.getHomeAddress()            ).isEqualTo( this.mock.getHomeAddress() );
//        assertThat( customer.getAddresses()              ).isEqualTo( this.mock.getAddresses() );
//        assertThat( customer.getBankCards()              ).isEqualTo( this.mock.getBankCards() );
//        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( this.mock.getAccumulatedExpenditure() );
//        assertThat( customer.getType()                   ).isEqualTo( this.mock.getType() );
//        assertThat( customer.getComments()               ).isEqualTo( this.mock.getComments() );
//        assertThat( customer.getLicense()                ).isEqualTo( this.mock.getLicense() );
//        assertThat( customer.getAudit()                  ).isEqualTo( this.mock.getAudit() );
//    }

    @Test
    void setterTest() {
        Customer customer = Customer.builder().build();

        customer.setId                    ( this.mock.getId() );
//        customer.setUser                  ( this.mock.getUser() );
//        customer.setDocumentType          ( this.mock.getDocumentType() );
//        customer.setDocument              ( this.mock.getDocument() );
//        customer.setName                  ( this.mock.getName() );
//        customer.setSurnames              ( this.mock.getSurnames() );
//        customer.setGender                ( this.mock.getGender() );
//        customer.setBirthdate             ( this.mock.getBirthdate() );
        customer.setCountry               ( this.mock.getCountry() );
//        customer.setPhoneNumber           ( this.mock.getPhoneNumber() );
        customer.setHomeAddress           ( this.mock.getHomeAddress() );
        customer.setAddresses             ( this.mock.getAddresses() );
        customer.setBankCards             ( this.mock.getBankCards() );
        customer.setAccumulatedExpenditure( this.mock.getAccumulatedExpenditure() );
        customer.setType                  ( this.mock.getType() );
        customer.setComments              ( this.mock.getComments() );
        customer.setLicense               ( this.mock.getLicense() );
        customer.setAudit                 ( this.mock.getAudit() );

        assertThat( customer.getId()                     ).isEqualTo( this.mock.getId() );
//        assertThat( customer.getUser()                   ).isEqualTo( this.mock.getUser() );
//        assertThat( customer.getDocumentType()           ).isEqualTo( this.mock.getDocumentType() );
//        assertThat( customer.getDocument()               ).isEqualTo( this.mock.getDocument() );
//        assertThat( customer.getName()                   ).isEqualTo( this.mock.getName() );
//        assertThat( customer.getSurnames()               ).isEqualTo( this.mock.getSurnames() );
//        assertThat( customer.getGender()                 ).isEqualTo( this.mock.getGender() );
//        assertThat( customer.getBirthdate()              ).isEqualTo( this.mock.getBirthdate() );
        assertThat( customer.getCountry()                ).isEqualTo( this.mock.getCountry() );
//        assertThat( customer.getPhoneNumber()            ).isEqualTo( this.mock.getPhoneNumber() );
        assertThat( customer.getHomeAddress()            ).isEqualTo( this.mock.getHomeAddress() );
        assertThat( customer.getAddresses()              ).isEqualTo( this.mock.getAddresses() );
        assertThat( customer.getBankCards()              ).isEqualTo( this.mock.getBankCards() );
        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( this.mock.getAccumulatedExpenditure() );
        assertThat( customer.getType()                   ).isEqualTo( this.mock.getType() );
        assertThat( customer.getComments()               ).isEqualTo( this.mock.getComments() );
        assertThat( customer.getLicense()                ).isEqualTo( this.mock.getLicense() );
        assertThat( customer.getAudit()                  ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void builderTest() {
        Customer customer = Customer.builder()
                .id                    ( this.mock.getId() )
//                .user                  ( this.mock.getUser() )
//                .documentType          ( this.mock.getDocumentType() )
//                .document              ( this.mock.getDocument() )
//                .name                  ( this.mock.getName() )
//                .surnames              ( this.mock.getSurnames() )
//                .gender                ( this.mock.getGender())
//                .birthdate             ( this.mock.getBirthdate() )
                .country               ( this.mock.getCountry() )
//                .phoneNumber           ( this.mock.getPhoneNumber() )
                .homeAddress           ( this.mock.getHomeAddress() )
                .addresses             ( this.mock.getAddresses() )
                .bankCards             ( this.mock.getBankCards() )
                .accumulatedExpenditure( this.mock.getAccumulatedExpenditure() )
                .type                  ( this.mock.getType() )
                .comments              ( this.mock.getComments() )
                .license               ( this.mock.getLicense() )
                .audit                 ( this.mock.getAudit() )
                .build();

        assertThat( customer.getId()                     ).isEqualTo( this.mock.getId() );
//        assertThat( customer.getUser()                   ).isEqualTo( this.mock.getUser() );
//        assertThat( customer.getDocumentType()           ).isEqualTo( this.mock.getDocumentType() );
//        assertThat( customer.getDocument()               ).isEqualTo( this.mock.getDocument() );
//        assertThat( customer.getName()                   ).isEqualTo( this.mock.getName() );
//        assertThat( customer.getSurnames()               ).isEqualTo( this.mock.getSurnames() );
//        assertThat( customer.getGender()                 ).isEqualTo( this.mock.getGender() );
//        assertThat( customer.getBirthdate()              ).isEqualTo( this.mock.getBirthdate() );
        assertThat( customer.getCountry()                ).isEqualTo( this.mock.getCountry() );
//        assertThat( customer.getPhoneNumber()            ).isEqualTo( this.mock.getPhoneNumber() );
        assertThat( customer.getHomeAddress()            ).isEqualTo( this.mock.getHomeAddress() );
        assertThat( customer.getAddresses()              ).isEqualTo( this.mock.getAddresses() );
        assertThat( customer.getBankCards()              ).isEqualTo( this.mock.getBankCards() );
        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( this.mock.getAccumulatedExpenditure() );
        assertThat( customer.getType()                   ).isEqualTo( this.mock.getType() );
        assertThat( customer.getComments()               ).isEqualTo( this.mock.getComments() );
        assertThat( customer.getLicense()                ).isEqualTo( this.mock.getLicense() );
        assertThat( customer.getAudit()                  ).isEqualTo( this.mock.getAudit() );
    }

}
