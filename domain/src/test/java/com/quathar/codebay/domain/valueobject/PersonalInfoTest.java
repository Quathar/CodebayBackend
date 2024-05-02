package com.quathar.codebay.domain.valueobject;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Personal Info Value Object Test</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
class PersonalInfoTest {

    // <<-FIELD->>
    private PersonalInfo mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(PersonalInfo.class);
    }

    @Test
    void builderTest() {
        PersonalInfo personalInfo = PersonalInfo.builder()
                .document ( this.mock.getDocument()  )
                .name     ( this.mock.getName()      )
                .surnames ( this.mock.getSurnames()  )
                .gender   ( this.mock.getGender()    )
                .birthdate( this.mock.getBirthdate() )
                .phone    ( this.mock.getPhone()     )
                .build();

        assertThat( personalInfo.getDocument()  ).isEqualTo( this.mock.getDocument()  );
        assertThat( personalInfo.getName()      ).isEqualTo( this.mock.getName()      );
        assertThat( personalInfo.getSurnames()  ).isEqualTo( this.mock.getSurnames()  );
        assertThat( personalInfo.getGender()    ).isEqualTo( this.mock.getGender()    );
        assertThat( personalInfo.getBirthdate() ).isEqualTo( this.mock.getBirthdate() );
        assertThat( personalInfo.getPhone()     ).isEqualTo( this.mock.getPhone()     );
    }

    @Test
    void settersTest() {
        PersonalInfo personalInfo = PersonalInfo.builder().build();

        personalInfo.setDocument ( this.mock.getDocument()  );
        personalInfo.setName     ( this.mock.getName()      );
        personalInfo.setSurnames ( this.mock.getSurnames()  );
        personalInfo.setGender   ( this.mock.getGender()    );
        personalInfo.setBirthdate( this.mock.getBirthdate() );
        personalInfo.setPhone    ( this.mock.getPhone()     );

        assertThat( personalInfo.getDocument()  ).isEqualTo( this.mock.getDocument()  );
        assertThat( personalInfo.getName()      ).isEqualTo( this.mock.getName()      );
        assertThat( personalInfo.getSurnames()  ).isEqualTo( this.mock.getSurnames()  );
        assertThat( personalInfo.getGender()    ).isEqualTo( this.mock.getGender()    );
        assertThat( personalInfo.getBirthdate() ).isEqualTo( this.mock.getBirthdate() );
        assertThat( personalInfo.getPhone()     ).isEqualTo( this.mock.getPhone()     );
    }

}
