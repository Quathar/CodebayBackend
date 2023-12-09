package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.enumerator.UserStatus;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>User Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class UserTests {

    // <<-CONSTANTS->>
    protected static final String USERNAME = "jdoe";
    protected static final String PASSWORD = "password";
    protected static final String NICKNAME = "John Doe";
    protected static final String EMAIL = "jdoe@email.com";
    protected static final Integer SUCCESSFUL_AUTH = 2;
    protected static final Integer FAILED_AUTH = 1;

    // <<-TEST->>
    @Test
    void userSettersTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime lastConnection = LocalDateTime.now();
        LocalDateTime releaseBlock   = LocalDateTime.now();

        User user = User.builder().build();

        user.setId            ( id );
        user.setUsername      ( USERNAME );
        user.setPassword      ( PASSWORD );
        user.setNickname      ( NICKNAME );
        user.setEmail         ( EMAIL );
        user.setSuccessfulAuth( SUCCESSFUL_AUTH );
        user.setFailedAuth    ( FAILED_AUTH );
        user.setLastConnection( lastConnection );
        user.setReleaseBlock  ( releaseBlock );
        user.setStatus        ( UserStatus.ACTIVE );
        user.setAudit         ( null );

        assertThat( user.getId()             ).isEqualTo( id );
        assertThat( user.getUsername()       ).isEqualTo( USERNAME );
        assertThat( user.getPassword()       ).isEqualTo( PASSWORD );
        assertThat( user.getNickname()       ).isEqualTo( NICKNAME );
        assertThat( user.getEmail()          ).isEqualTo( EMAIL );
        assertThat( user.getSuccessfulAuth() ).isEqualTo( SUCCESSFUL_AUTH );
        assertThat( user.getFailedAuth()     ).isEqualTo( FAILED_AUTH );
        assertThat( user.getLastConnection() ).isEqualTo( lastConnection );
        assertThat( user.getReleaseBlock()   ).isEqualTo( releaseBlock );
        assertThat( user.getStatus()         ).isEqualTo( UserStatus.ACTIVE );
        assertThat( user.getAudit()          ).isEqualTo( null );
    }

    @Test
    void userBuilderTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime lastConnection = LocalDateTime.now();
        LocalDateTime releaseBlock   = LocalDateTime.now();

        User user = User.builder()
                .id            ( id )
                .username      ( USERNAME )
                .password      ( PASSWORD )
                .nickname      ( NICKNAME )
                .email         ( EMAIL )
                .successfulAuth( SUCCESSFUL_AUTH )
                .failedAuth    ( FAILED_AUTH )
                .lastConnection( lastConnection )
                .releaseBlock  ( releaseBlock )
                .status        ( UserStatus.ACTIVE )
                .audit         ( null )
                .build();

        assertThat( user.getId()             ).isEqualTo( id );
        assertThat( user.getUsername()       ).isEqualTo( USERNAME );
        assertThat( user.getPassword()       ).isEqualTo( PASSWORD );
        assertThat( user.getNickname()       ).isEqualTo( NICKNAME );
        assertThat( user.getEmail()          ).isEqualTo( EMAIL );
        assertThat( user.getSuccessfulAuth() ).isEqualTo( SUCCESSFUL_AUTH );
        assertThat( user.getFailedAuth()     ).isEqualTo( FAILED_AUTH );
        assertThat( user.getLastConnection() ).isEqualTo( lastConnection );
        assertThat( user.getReleaseBlock()   ).isEqualTo( releaseBlock );
        assertThat( user.getStatus()         ).isEqualTo( UserStatus.ACTIVE );
        assertThat( user.getAudit()          ).isEqualTo( null );
    }

}
