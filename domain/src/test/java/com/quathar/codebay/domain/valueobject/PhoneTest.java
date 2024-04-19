package com.quathar.codebay.domain.valueobject;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Phone Value Object Test</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
class PhoneTest {

    // <<-FIELD->>
    private Phone mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Phone.class);
    }

    @Test
    void builderTest() {
        Phone phone = Phone.builder()
                .countryCode( this.mock.getCountryCode() )
                .number     ( this.mock.getNumber() )
                .build();

        assertThat( phone.getCountryCode() ).isEqualTo( this.mock.getCountryCode() );
        assertThat( phone.getNumber()      ).isEqualTo( this.mock.getNumber()      );
    }

    @Test
    void settersTest() {
        Phone phone = Phone.builder().build();

        phone.setCountryCode( this.mock.getCountryCode() );
        phone.setNumber     ( this.mock.getNumber()      );

        assertThat( phone.getCountryCode() ).isEqualTo( this.mock.getCountryCode() );
        assertThat( phone.getNumber()      ).isEqualTo( this.mock.getNumber()      );
    }

}
