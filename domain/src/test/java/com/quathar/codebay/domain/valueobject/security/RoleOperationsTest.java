package com.quathar.codebay.domain.valueobject.security;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Role Operations Value Object Tests</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
class RoleOperationsTest {

    // <<-FIELD->>
    private RoleOperations mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(RoleOperations.class);
    }

    @Test
    void builderTest() {
        RoleOperations roleOperations = RoleOperations.builder()
                .role      ( this.mock.getRole()       )
                .operations( this.mock.getOperations() )
                .build();

        assertThat( roleOperations.getRole()       ).isEqualTo( this.mock.getRole()       );
        assertThat( roleOperations.getOperations() ).isEqualTo( this.mock.getOperations() );
    }

    @Test
    void settersTest() {
        RoleOperations roleOperations = RoleOperations.builder().build();

        roleOperations.setRole      ( this.mock.getRole()       );
        roleOperations.setOperations( this.mock.getOperations() );


        assertThat( roleOperations.getRole()       ).isEqualTo( this.mock.getRole()       );
        assertThat( roleOperations.getOperations() ).isEqualTo( this.mock.getOperations() );
    }

}
