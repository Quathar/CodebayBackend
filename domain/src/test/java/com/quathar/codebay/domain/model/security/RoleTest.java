package com.quathar.codebay.domain.model.security;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Role Model Tests</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
public class RoleTest {

    // <<-FIELD->>
    private Role mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Role.class);
    }

    @Test
    void builderTest() {
        Role role = Role.builder()
                .id                ( this.mock.getId()                 )
                .name              ( this.mock.getName()               )
                .description       ( this.mock.getDescription()        )
                .grantedPermissions( this.mock.getGrantedPermissions() )
                .build();

        assertThat( role.getId()                 ).isEqualTo( this.mock.getId()                 );
        assertThat( role.getName()               ).isEqualTo( this.mock.getName()               );
        assertThat( role.getDescription()        ).isEqualTo( this.mock.getDescription()        );
        assertThat( role.getGrantedPermissions() ).isEqualTo( this.mock.getGrantedPermissions() );
    }

    @Test
    void settersTest() {
        Role role = Role.builder().build();

        role.setId                ( this.mock.getId()                 );
        role.setName              ( this.mock.getName()               );
        role.setDescription       ( this.mock.getDescription()        );
        role.setGrantedPermissions( this.mock.getGrantedPermissions() );

        assertThat( role.getId()                 ).isEqualTo( this.mock.getId()                 );
        assertThat( role.getName()               ).isEqualTo( this.mock.getName()               );
        assertThat( role.getDescription()        ).isEqualTo( this.mock.getDescription()        );
        assertThat( role.getGrantedPermissions() ).isEqualTo( this.mock.getGrantedPermissions() );
    }

}
