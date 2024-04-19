package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Administrator Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class AdministratorTest {

    // <<-FIELD->>
    private Administrator mock;

    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Administrator.class);
    }

    // <<-TESTS->>
    @Test
    void builderTest() {
        Administrator admin = Administrator.builder()
                .personalInfo( this.mock.getPersonalInfo() )
                .build();

        assertThat( admin.getPersonalInfo() ).isEqualTo( this.mock.getPersonalInfo() );
    }

    @Test
    void settersTest() {
        Administrator admin = Administrator.builder().build();

        admin.setPersonalInfo( this.mock.getPersonalInfo() );

        assertThat( admin.getPersonalInfo() ).isEqualTo( this.mock.getPersonalInfo() );
    }

}
