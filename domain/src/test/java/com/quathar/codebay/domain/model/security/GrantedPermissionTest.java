package com.quathar.codebay.domain.model.security;

import com.quathar.codebay.domain.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Granted Permission Model Tests</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
class GrantedPermissionTest {

    // <<-FIELD->>
    private GrantedPermission mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(GrantedPermission.class);
    }

    @Test
    void builderTest() {
        GrantedPermission grantedPermission = GrantedPermission.builder()
                .id       ( this.mock.getId()        )
                .role     ( this.mock.getRole()      )
                .operation( this.mock.getOperation() )
                .build();

        assertThat( grantedPermission.getId()        ).isEqualTo( this.mock.getId()        );
        assertThat( grantedPermission.getRole()      ).isEqualTo( this.mock.getRole()      );
        assertThat( grantedPermission.getOperation() ).isEqualTo( this.mock.getOperation() );
    }

    @Test
    void settersTest() {
        GrantedPermission grantedPermission = GrantedPermission.builder().build();

        grantedPermission.setId       ( this.mock.getId()        );
        grantedPermission.setRole     ( this.mock.getRole()      );
        grantedPermission.setOperation( this.mock.getOperation() );

        assertThat( grantedPermission.getId()        ).isEqualTo( this.mock.getId()        );
        assertThat( grantedPermission.getRole()      ).isEqualTo( this.mock.getRole()      );
        assertThat( grantedPermission.getOperation() ).isEqualTo( this.mock.getOperation() );
    }

}
