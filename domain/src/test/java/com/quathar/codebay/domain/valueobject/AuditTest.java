package com.quathar.codebay.domain.valueobject;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Audit Value Object Tests</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
class AuditTest {

    // <<-FIELD->>
    private Audit mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Audit.class);
    }

    @Test
    void builderTest() {
        Audit audit = Audit.builder()
                .creationDate    ( this.mock.getCreationDate()     )
                .createdBy       ( this.mock.getCreatedBy()        )
                .modificationDate( this.mock.getModificationDate() )
                .modificationBy  ( this.mock.getModificationBy()   )
                .deletionDate    ( this.mock.getDeletionDate()     )
                .deletedBy       ( this.mock.getDeletedBy()        )
                .build();

        assertThat( audit.getCreationDate()     ).isEqualTo( this.mock.getCreationDate()     );
        assertThat( audit.getCreatedBy()        ).isEqualTo( this.mock.getCreatedBy()        );
        assertThat( audit.getModificationDate() ).isEqualTo( this.mock.getModificationDate() );
        assertThat( audit.getModificationBy()   ).isEqualTo( this.mock.getModificationBy()   );
        assertThat( audit.getDeletionDate()     ).isEqualTo( this.mock.getDeletionDate()     );
        assertThat( audit.getDeletedBy()        ).isEqualTo( this.mock.getDeletedBy()        );
    }

    @Test
    void settersTest() {
        Audit audit = Audit.builder().build();

        audit.setCreationDate    ( this.mock.getCreationDate()      );
        audit.setCreatedBy       ( this.mock.getCreatedBy()         );
        audit.setModificationDate( this.mock.getModificationDate()  );
        audit.setModificationBy  ( this.mock.getModificationBy()    );
        audit.setDeletionDate    ( this.mock.getDeletionDate()      );
        audit.setDeletedBy       ( this.mock.getDeletedBy()         );

        assertThat( audit.getCreationDate()     ).isEqualTo( this.mock.getCreationDate()     );
        assertThat( audit.getCreatedBy()        ).isEqualTo( this.mock.getCreatedBy()        );
        assertThat( audit.getModificationDate() ).isEqualTo( this.mock.getModificationDate() );
        assertThat( audit.getModificationBy()   ).isEqualTo( this.mock.getModificationBy()   );
        assertThat( audit.getDeletionDate()     ).isEqualTo( this.mock.getDeletionDate()     );
        assertThat( audit.getDeletedBy()        ).isEqualTo( this.mock.getDeletedBy()        );
    }

}
