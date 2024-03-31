package com.quathar.codebay.domain.model.security;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Operation Model Tests</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
public class OperationTest {

    // <<-FIELD->>
    private Operation mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Operation.class);
    }

    @Test
    void builderTest() {
        Operation operation = Operation.builder()
                .id  ( this.mock.getId()   )
                .name( this.mock.getName() )
                .build();

        assertThat( operation.getId()   ).isEqualTo( this.mock.getId()   );
        assertThat( operation.getName() ).isEqualTo( this.mock.getName() );
    }

    @Test
    void settersTest() {
        Operation operation = Operation.builder().build();

        operation.setId  ( this.mock.getId()   );
        operation.setName( this.mock.getName() );

        assertThat( operation.getId()   ).isEqualTo( this.mock.getId()   );
        assertThat( operation.getName() ).isEqualTo( this.mock.getName() );
    }

}
