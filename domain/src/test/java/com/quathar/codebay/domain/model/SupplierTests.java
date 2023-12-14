package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Supplier Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class SupplierTests {

    // <<-FIELD->>
    private Supplier mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Supplier.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Supplier warning = new Supplier(
                this.mock.getId(),
                this.mock.getDocumentType(),
                this.mock.getDocument(),
                this.mock.getName(),
                this.mock.getAddress(),
                this.mock.getEmail(),
                this.mock.getPhoneNumber(),
                this.mock.getLandlineNumber(),
                this.mock.getType(),
                this.mock.getComments(),
                this.mock.getWeb(),
                this.mock.getAudit()
        );

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDocumentType()   ).isEqualTo( this.mock.getDocumentType() );
        assertThat( warning.getDocument()       ).isEqualTo( this.mock.getDocument() );
        assertThat( warning.getName()           ).isEqualTo( this.mock.getName() );
        assertThat( warning.getAddress()        ).isEqualTo( this.mock.getAddress() );
        assertThat( warning.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( warning.getPhoneNumber()    ).isEqualTo( this.mock.getPhoneNumber() );
        assertThat( warning.getLandlineNumber() ).isEqualTo( this.mock.getLandlineNumber() );
        assertThat( warning.getType()           ).isEqualTo( this.mock.getType() );
        assertThat( warning.getComments()       ).isEqualTo( this.mock.getComments() );
        assertThat( warning.getWeb()            ).isEqualTo( this.mock.getWeb() );
        assertThat( warning.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void setterTest() {
        Supplier warning = Supplier.builder().build();

        warning.setId             ( this.mock.getId() );

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDocumentType()   ).isEqualTo( this.mock.getDocumentType() );
        assertThat( warning.getDocument()       ).isEqualTo( this.mock.getDocument() );
        assertThat( warning.getName()           ).isEqualTo( this.mock.getName() );
        assertThat( warning.getAddress()        ).isEqualTo( this.mock.getAddress() );
        assertThat( warning.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( warning.getPhoneNumber()    ).isEqualTo( this.mock.getPhoneNumber() );
        assertThat( warning.getLandlineNumber() ).isEqualTo( this.mock.getLandlineNumber() );
        assertThat( warning.getType()           ).isEqualTo( this.mock.getType() );
        assertThat( warning.getComments()       ).isEqualTo( this.mock.getComments() );
        assertThat( warning.getWeb()            ).isEqualTo( this.mock.getWeb() );
        assertThat( warning.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void builderTest() {
        Supplier warning = Supplier.builder()
                .id            ( this.mock.getId() )
                .documentType  ( this.mock.getDocumentType())
                .document      ( this.mock.getDocument())
                .name          ( this.mock.getName())
                .address       ( this.mock.getAddress())
                .email         ( this.mock.getEmail())
                .phoneNumber   ( this.mock.getPhoneNumber())
                .landlineNumber( this.mock.getLandlineNumber())
                .type          ( this.mock.getType())
                .comments      ( this.mock.getComments())
                .web           ( this.mock.getWeb())
                .audit         ( this.mock.getAudit())
                .build();

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDocumentType()   ).isEqualTo( this.mock.getDocumentType() );
        assertThat( warning.getDocument()       ).isEqualTo( this.mock.getDocument() );
        assertThat( warning.getName()           ).isEqualTo( this.mock.getName() );
        assertThat( warning.getAddress()        ).isEqualTo( this.mock.getAddress() );
        assertThat( warning.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( warning.getPhoneNumber()    ).isEqualTo( this.mock.getPhoneNumber() );
        assertThat( warning.getLandlineNumber() ).isEqualTo( this.mock.getLandlineNumber() );
        assertThat( warning.getType()           ).isEqualTo( this.mock.getType() );
        assertThat( warning.getComments()       ).isEqualTo( this.mock.getComments() );
        assertThat( warning.getWeb()            ).isEqualTo( this.mock.getWeb() );
        assertThat( warning.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

}
