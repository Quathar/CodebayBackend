package com.quathar.codebay.domain.valueobject;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Document Value Object Test</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
class DocumentTest {

    // <<-FIELD->>
    private Document mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Document.class);
    }

    @Test
    void builderTest() {
        Document document = Document.builder()
                .type   ( this.mock.getType()    )
                .content( this.mock.getContent() )
                .build();

        assertThat( document.getType()    ).isEqualTo( this.mock.getType()    );
        assertThat( document.getContent() ).isEqualTo( this.mock.getContent() );
    }

    @Test
    void settersTest() {
        Document document = Document.builder().build();

        document.setType   ( this.mock.getType()    );
        document.setContent( this.mock.getContent() );

        assertThat( document.getType()    ).isEqualTo( this.mock.getType()    );
        assertThat( document.getContent() ).isEqualTo( this.mock.getContent() );
    }

}
