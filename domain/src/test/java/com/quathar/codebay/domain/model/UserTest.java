package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>User Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class UserTest {

    // <<-FIELD->>
    private User mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(User.class);
    }

    @Test
    void builderTest() {
        User user = User.builder()
                .id                    ( this.mock.getId()                     )
                .username              ( this.mock.getUsername()               )
                .password              ( this.mock.getPassword()               )
                .nickname              ( this.mock.getNickname()               )
                .email                 ( this.mock.getEmail()                  )
                .status                ( this.mock.getStatus()                 )
                .role                  ( this.mock.getRole()                   )
                .successfulAuth        ( this.mock.getSuccessfulAuth()         )
                .failedAuth            ( this.mock.getFailedAuth()             )
                .creationDate          ( this.mock.getCreationDate()           )
                .passwordExpirationDate( this.mock.getPasswordExpirationDate() )
                .endBlockDate          ( this.mock.getEndBlockDate()           )
                .lastConnection        ( this.mock.getLastConnection()         )
//                .audit         ( this.mock.getAudit() )
                .build();

        assertThat( user.getId()                     ).isEqualTo( this.mock.getId()                     );
        assertThat( user.getUsername()               ).isEqualTo( this.mock.getUsername()               );
        assertThat( user.getPassword()               ).isEqualTo( this.mock.getPassword()               );
        assertThat( user.getNickname()               ).isEqualTo( this.mock.getNickname()               );
        assertThat( user.getEmail()                  ).isEqualTo( this.mock.getEmail()                  );
        assertThat( user.getStatus()                 ).isEqualTo( this.mock.getStatus()                 );
        assertThat( user.getRole()                   ).isEqualTo( this.mock.getRole()                   );
        assertThat( user.getSuccessfulAuth()         ).isEqualTo( this.mock.getSuccessfulAuth()         );
        assertThat( user.getFailedAuth()             ).isEqualTo( this.mock.getFailedAuth()             );
        assertThat( user.getCreationDate()           ).isEqualTo( this.mock.getLastConnection()         );
        assertThat( user.getPasswordExpirationDate() ).isEqualTo( this.mock.getPasswordExpirationDate() );
        assertThat( user.getEndBlockDate()           ).isEqualTo( this.mock.getEndBlockDate()           );
        assertThat( user.getLastConnection()         ).isEqualTo( this.mock.getLastConnection()         );
//        assertThat( user.getAudit()                  ).isEqualTo( this.mock.getAudit()                  );
    }

    @Test
    void settersTest() {
        User user = User.builder().build();

        user.setId                    ( this.mock.getId()                     );
        user.setUsername              ( this.mock.getUsername()               );
        user.setPassword              ( this.mock.getPassword()               );
        user.setNickname              ( this.mock.getNickname()               );
        user.setEmail                 ( this.mock.getEmail()                  );
        user.setStatus                ( this.mock.getStatus()                 );
        user.setRole                  ( this.mock.getRole()                   );
        user.setSuccessfulAuth        ( this.mock.getSuccessfulAuth()         );
        user.setFailedAuth            ( this.mock.getFailedAuth()             );
        user.setCreationDate          ( this.mock.getCreationDate()           );
        user.setPasswordExpirationDate( this.mock.getPasswordExpirationDate() );
        user.setEndBlockDate          ( this.mock.getEndBlockDate()           );
        user.setLastConnection        ( this.mock.getLastConnection()         );
//        user.setAudit                 ( this.mock.getAudit()                  );

        assertThat( user.getId()                     ).isEqualTo( this.mock.getId()                     );
        assertThat( user.getUsername()               ).isEqualTo( this.mock.getUsername()               );
        assertThat( user.getPassword()               ).isEqualTo( this.mock.getPassword()               );
        assertThat( user.getNickname()               ).isEqualTo( this.mock.getNickname()               );
        assertThat( user.getEmail()                  ).isEqualTo( this.mock.getEmail()                  );
        assertThat( user.getStatus()                 ).isEqualTo( this.mock.getStatus()                 );
        assertThat( user.getRole()                   ).isEqualTo( this.mock.getRole()                   );
        assertThat( user.getSuccessfulAuth()         ).isEqualTo( this.mock.getSuccessfulAuth()         );
        assertThat( user.getFailedAuth()             ).isEqualTo( this.mock.getFailedAuth()             );
        assertThat( user.getCreationDate()           ).isEqualTo( this.mock.getLastConnection()         );
        assertThat( user.getPasswordExpirationDate() ).isEqualTo( this.mock.getPasswordExpirationDate() );
        assertThat( user.getEndBlockDate()           ).isEqualTo( this.mock.getEndBlockDate()           );
        assertThat( user.getLastConnection()         ).isEqualTo( this.mock.getLastConnection()         );
//        assertThat( user.getAudit()                  ).isEqualTo( this.mock.getAudit()                  );
    }

}
