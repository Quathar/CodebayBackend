package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.ModelProvider;
import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.BankCard;
import com.quathar.codebay.domain.model.enumerator.Gender;
import com.quathar.codebay.domain.model.type.Country;
import com.quathar.codebay.domain.model.type.CustomerType;
import com.quathar.codebay.domain.model.type.DocumentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Customer Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class CustomerTests {

    // <<-CONSTANTS->>
    private static final String DOCUMENT = "12345678A";
    private static final String NAME = "John";
    private static final String SURNAMES = "Doe";
    private static final LocalDate BIRTHDATE = LocalDate.parse("1999-09-09");
    private static final String PHONE_NUMBER = "+34 600 00 00 00";
    private static final BigDecimal ACCUMULATED_EXPENDITURE = BigDecimal.valueOf(56.25);
    private static final String COMMENTS = "some comments";
    private static final Boolean LICENSE = true;

    // <<-FIELDS->>
    private UUID id;
    private User user;
    private DocumentType documentType;
    private Country country;
    private Address homeAddress;
    private Set<Address> addresses;
    private Set<BankCard> bankCards;
    private CustomerType type;
    private Audit audit;

    // <<-TEST->>
    @BeforeEach
    void setUp() {
        this.id           = UUID.randomUUID();
        this.user         = ModelProvider.getInstance(User.class);
        this.documentType = ModelProvider.getInstance(DocumentType.class);
        this.country      = ModelProvider.getInstance(Country.class);
        this.homeAddress  = ModelProvider.getInstance(Address.class);
        this.addresses    = Set.of(ModelProvider.getInstance(Address.class));
        this.bankCards    = Set.of(ModelProvider.getInstance(BankCard.class));
        this.type         = ModelProvider.getInstance(CustomerType.class);
        this.audit        = ModelProvider.getInstance(Audit.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Customer customer = new Customer(
                this.id,
                this.user,
                this.documentType,
                DOCUMENT,
                NAME,
                SURNAMES,
                Gender.MALE,
                BIRTHDATE,
                this.country,
                PHONE_NUMBER,
                this.homeAddress,
                this.addresses,
                this.bankCards,
                ACCUMULATED_EXPENDITURE,
                this.type,
                COMMENTS,
                LICENSE,
                this.audit
        );

        assertThat( customer.getId()                     ).isEqualTo( this.id );
        assertThat( customer.getUser()                   ).isEqualTo( this.user );
        assertThat( customer.getDocumentType()           ).isEqualTo( this.documentType );
        assertThat( customer.getDocument()               ).isEqualTo( DOCUMENT );
        assertThat( customer.getName()                   ).isEqualTo( NAME );
        assertThat( customer.getSurnames()               ).isEqualTo( SURNAMES );
        assertThat( customer.getGender()                 ).isEqualTo( Gender.MALE );
        assertThat( customer.getBirthdate()              ).isEqualTo( BIRTHDATE );
        assertThat( customer.getCountry()                ).isEqualTo( this.country );
        assertThat( customer.getPhoneNumber()            ).isEqualTo( PHONE_NUMBER );
        assertThat( customer.getHomeAddress()            ).isEqualTo( this.homeAddress );
        assertThat( customer.getAddresses()              ).isEqualTo( this.addresses );
        assertThat( customer.getBankCards()              ).isEqualTo( this.bankCards );
        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( ACCUMULATED_EXPENDITURE );
        assertThat( customer.getType()                   ).isEqualTo( this.type );
        assertThat( customer.getComments()               ).isEqualTo( COMMENTS );
        assertThat( customer.getLicense()                ).isEqualTo( LICENSE );
        assertThat( customer.getAudit()                  ).isEqualTo( this.audit );
    }

    @Test
    void setterTest() {
        Customer customer = Customer.builder().build();

        customer.setId                    ( this.id );
        customer.setUser                  ( this.user );
        customer.setDocumentType          ( this.documentType );
        customer.setDocument              ( DOCUMENT );
        customer.setName                  ( NAME );
        customer.setSurnames              ( SURNAMES );
        customer.setGender                ( Gender.MALE );
        customer.setBirthdate             ( BIRTHDATE );
        customer.setCountry               ( this.country );
        customer.setPhoneNumber           ( PHONE_NUMBER );
        customer.setHomeAddress           ( this.homeAddress );
        customer.setAddresses             ( this.addresses );
        customer.setBankCards             ( this.bankCards );
        customer.setAccumulatedExpenditure( ACCUMULATED_EXPENDITURE );
        customer.setType                  ( this.type );
        customer.setComments              ( COMMENTS );
        customer.setLicense               ( LICENSE );
        customer.setAudit                 ( this.audit );

        assertThat( customer.getId()                     ).isEqualTo( this.id );
        assertThat( customer.getUser()                   ).isEqualTo( this.user );
        assertThat( customer.getDocumentType()           ).isEqualTo( this.documentType );
        assertThat( customer.getDocument()               ).isEqualTo( DOCUMENT );
        assertThat( customer.getName()                   ).isEqualTo( NAME );
        assertThat( customer.getSurnames()               ).isEqualTo( SURNAMES );
        assertThat( customer.getGender()                 ).isEqualTo( Gender.MALE );
        assertThat( customer.getBirthdate()              ).isEqualTo( BIRTHDATE );
        assertThat( customer.getCountry()                ).isEqualTo( this.country );
        assertThat( customer.getPhoneNumber()            ).isEqualTo( PHONE_NUMBER );
        assertThat( customer.getHomeAddress()            ).isEqualTo( this.homeAddress );
        assertThat( customer.getAddresses()              ).isEqualTo( this.addresses );
        assertThat( customer.getBankCards()              ).isEqualTo( this.bankCards );
        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( ACCUMULATED_EXPENDITURE );
        assertThat( customer.getType()                   ).isEqualTo( this.type );
        assertThat( customer.getComments()               ).isEqualTo( COMMENTS );
        assertThat( customer.getLicense()                ).isEqualTo( LICENSE );
        assertThat( customer.getAudit()                  ).isEqualTo( this.audit );
    }

    @Test
    void builderTest() {
        Customer customer = Customer.builder()
                .id                    ( this.id )
                .user                  ( this.user )
                .documentType          ( this.documentType )
                .document              ( DOCUMENT )
                .name                  ( NAME )
                .surnames              ( SURNAMES )
                .gender                ( Gender.MALE )
                .birthdate             ( BIRTHDATE )
                .country               ( this.country )
                .phoneNumber           ( PHONE_NUMBER )
                .homeAddress           ( this.homeAddress )
                .addresses             ( this.addresses )
                .bankCards             ( this.bankCards )
                .accumulatedExpenditure( ACCUMULATED_EXPENDITURE )
                .type                  ( this.type )
                .comments              ( COMMENTS )
                .license               ( LICENSE )
                .audit                 ( this.audit)
                .build();

        assertThat( customer.getId()                     ).isEqualTo( this.id );
        assertThat( customer.getUser()                   ).isEqualTo( this.user );
        assertThat( customer.getDocumentType()           ).isEqualTo( this.documentType );
        assertThat( customer.getDocument()               ).isEqualTo( DOCUMENT );
        assertThat( customer.getName()                   ).isEqualTo( NAME );
        assertThat( customer.getSurnames()               ).isEqualTo( SURNAMES );
        assertThat( customer.getGender()                 ).isEqualTo( Gender.MALE );
        assertThat( customer.getBirthdate()              ).isEqualTo( BIRTHDATE );
        assertThat( customer.getCountry()                ).isEqualTo( this.country );
        assertThat( customer.getPhoneNumber()            ).isEqualTo( PHONE_NUMBER );
        assertThat( customer.getHomeAddress()            ).isEqualTo( this.homeAddress );
        assertThat( customer.getAddresses()              ).isEqualTo( this.addresses );
        assertThat( customer.getBankCards()              ).isEqualTo( this.bankCards );
        assertThat( customer.getAccumulatedExpenditure() ).isEqualTo( ACCUMULATED_EXPENDITURE );
        assertThat( customer.getType()                   ).isEqualTo( this.type );
        assertThat( customer.getComments()               ).isEqualTo( COMMENTS );
        assertThat( customer.getLicense()                ).isEqualTo( LICENSE );
        assertThat( customer.getAudit()                  ).isEqualTo( this.audit );
    }

}
