package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Warning Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class WarningTests {

    // <<-FIELD->>
    private Warning mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Warning.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Warning warning = new Warning(
                this.mock.getId(),
                this.mock.getDescription(),
                this.mock.getUrgency(),
                this.mock.getProcessingDate(),
                this.mock.getProcessedBy()
        );

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDescription()    ).isEqualTo( this.mock.getDescription() );
        assertThat( warning.getUrgency()        ).isEqualTo( this.mock.getUrgency() );
        assertThat( warning.getProcessingDate() ).isEqualTo( this.mock.getProcessingDate() );
        assertThat( warning.getProcessedBy()    ).isEqualTo( this.mock.getProcessedBy() );
    }

    @Test
    void setterTest() {
        Warning warning = Warning.builder().build();

        warning.setId             ( this.mock.getId() );
        warning.setDescription    ( this.mock.getDescription() );
        warning.setUrgency        ( this.mock.getUrgency() );
        warning.setProcessingDate ( this.mock.getProcessingDate() );
        warning.setProcessedBy    ( this.mock.getProcessedBy() );

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDescription()    ).isEqualTo( this.mock.getDescription() );
        assertThat( warning.getUrgency()        ).isEqualTo( this.mock.getUrgency() );
        assertThat( warning.getProcessingDate() ).isEqualTo( this.mock.getProcessingDate() );
        assertThat( warning.getProcessedBy()    ).isEqualTo( this.mock.getProcessedBy() );
    }

    @Test
    void builderTest() {
        Warning warning = Warning.builder()
                .id            ( this.mock.getId() )
                .description   ( this.mock.getDescription() )
                .urgency       ( this.mock.getUrgency() )
                .processingDate( this.mock.getProcessingDate() )
                .processedBy   ( this.mock.getProcessedBy() )
                .build();

        assertThat( warning.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( warning.getDescription()    ).isEqualTo( this.mock.getDescription() );
        assertThat( warning.getUrgency()        ).isEqualTo( this.mock.getUrgency() );
        assertThat( warning.getProcessingDate() ).isEqualTo( this.mock.getProcessingDate() );
        assertThat( warning.getProcessedBy()    ).isEqualTo( this.mock.getProcessedBy() );
    }

}
