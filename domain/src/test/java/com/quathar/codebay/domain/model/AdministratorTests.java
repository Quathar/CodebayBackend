package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

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
class AdministratorTests {

    // <<-FIELD->>
    private Administrator mock;

    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Administrator.class);
    }

    // <<-TEST->>
    @Test
    void adminSettersTest() {
        Administrator admin = Administrator.builder().build();

        admin.setId            ( this.mock.getId() );
        admin.setUsername      ( this.mock.getUsername() );
        admin.setPassword      ( this.mock.getPassword() );
        admin.setNickname      ( this.mock.getNickname() );
        admin.setEmail         ( this.mock.getEmail() );
        admin.setSuccessfulAuth( this.mock.getSuccessfulAuth() );
        admin.setFailedAuth    ( this.mock.getFailedAuth() );
        admin.setLastConnection( this.mock.getLastConnection() );
        admin.setReleaseBlock  ( this.mock.getReleaseBlock() );
        admin.setStatus        ( this.mock.getStatus() );
        admin.setAudit         ( this.mock.getAudit() );

        assertThat( admin.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( admin.getUsername()       ).isEqualTo( this.mock.getUsername() );
        assertThat( admin.getPassword()       ).isEqualTo( this.mock.getPassword() );
        assertThat( admin.getNickname()       ).isEqualTo( this.mock.getNickname() );
        assertThat( admin.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( admin.getSuccessfulAuth() ).isEqualTo( this.mock.getSuccessfulAuth() );
        assertThat( admin.getFailedAuth()     ).isEqualTo( this.mock.getFailedAuth() );
        assertThat( admin.getLastConnection() ).isEqualTo( this.mock.getLastConnection() );
        assertThat( admin.getReleaseBlock()   ).isEqualTo( this.mock.getReleaseBlock() );
        assertThat( admin.getStatus()         ).isEqualTo( this.mock.getStatus() );
        assertThat( admin.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void adminBuilderTest() {
        Administrator admin = Administrator.builder()
                .id            ( this.mock.getId() )
                .username      ( this.mock.getUsername() )
                .password      ( this.mock.getPassword() )
                .nickname      ( this.mock.getNickname() )
                .email         ( this.mock.getEmail() )
                .successfulAuth( this.mock.getSuccessfulAuth() )
                .failedAuth    ( this.mock.getFailedAuth() )
                .lastConnection( this.mock.getLastConnection() )
                .releaseBlock  ( this.mock.getReleaseBlock() )
                .status        ( this.mock.getStatus() )
                .audit         ( this.mock.getAudit() )
                .build();

        assertThat( admin.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( admin.getUsername()       ).isEqualTo( this.mock.getUsername() );
        assertThat( admin.getPassword()       ).isEqualTo( this.mock.getPassword() );
        assertThat( admin.getNickname()       ).isEqualTo( this.mock.getNickname() );
        assertThat( admin.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( admin.getSuccessfulAuth() ).isEqualTo( this.mock.getSuccessfulAuth() );
        assertThat( admin.getFailedAuth()     ).isEqualTo( this.mock.getFailedAuth() );
        assertThat( admin.getLastConnection() ).isEqualTo( this.mock.getLastConnection() );
        assertThat( admin.getReleaseBlock()   ).isEqualTo( this.mock.getReleaseBlock() );
        assertThat( admin.getStatus()         ).isEqualTo( this.mock.getStatus() );
        assertThat( admin.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

}
