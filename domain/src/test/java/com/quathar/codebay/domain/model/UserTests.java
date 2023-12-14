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
class UserTests {

    // <<-FIELD->>
    private User mock;

    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(User.class);
    }

    // <<-TEST->>
    @Test
    void userSettersTest() {
        User user = User.builder().build();

        user.setId            ( this.mock.getId() );
        user.setUsername      ( this.mock.getUsername() );
        user.setPassword      ( this.mock.getPassword() );
        user.setNickname      ( this.mock.getNickname() );
        user.setEmail         ( this.mock.getEmail() );
        user.setSuccessfulAuth( this.mock.getSuccessfulAuth() );
        user.setFailedAuth    ( this.mock.getFailedAuth() );
        user.setLastConnection( this.mock.getLastConnection() );
        user.setReleaseBlock  ( this.mock.getReleaseBlock() );
        user.setStatus        ( this.mock.getStatus() );
        user.setAudit         ( this.mock.getAudit() );

        assertThat( user.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( user.getUsername()       ).isEqualTo( this.mock.getUsername() );
        assertThat( user.getPassword()       ).isEqualTo( this.mock.getPassword() );
        assertThat( user.getNickname()       ).isEqualTo( this.mock.getNickname() );
        assertThat( user.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( user.getSuccessfulAuth() ).isEqualTo( this.mock.getSuccessfulAuth() );
        assertThat( user.getFailedAuth()     ).isEqualTo( this.mock.getFailedAuth() );
        assertThat( user.getLastConnection() ).isEqualTo( this.mock.getLastConnection() );
        assertThat( user.getReleaseBlock()   ).isEqualTo( this.mock.getReleaseBlock() );
        assertThat( user.getStatus()         ).isEqualTo( this.mock.getStatus() );
        assertThat( user.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void userBuilderTest() {
        User user = User.builder()
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

        assertThat( user.getId()             ).isEqualTo( this.mock.getId() );
        assertThat( user.getUsername()       ).isEqualTo( this.mock.getUsername() );
        assertThat( user.getPassword()       ).isEqualTo( this.mock.getPassword() );
        assertThat( user.getNickname()       ).isEqualTo( this.mock.getNickname() );
        assertThat( user.getEmail()          ).isEqualTo( this.mock.getEmail() );
        assertThat( user.getSuccessfulAuth() ).isEqualTo( this.mock.getSuccessfulAuth() );
        assertThat( user.getFailedAuth()     ).isEqualTo( this.mock.getFailedAuth() );
        assertThat( user.getLastConnection() ).isEqualTo( this.mock.getLastConnection() );
        assertThat( user.getReleaseBlock()   ).isEqualTo( this.mock.getReleaseBlock() );
        assertThat( user.getStatus()         ).isEqualTo( this.mock.getStatus() );
        assertThat( user.getAudit()          ).isEqualTo( this.mock.getAudit() );
    }

}
