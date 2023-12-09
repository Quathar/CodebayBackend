package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.enumerator.UserStatus;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Administrator Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class AdministratorTests extends UserTests {

    // <<-TEST->>
    @Test
    void adminSettersTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime lastConnection = LocalDateTime.now();
        LocalDateTime releaseBlock = LocalDateTime.now();

        Administrator admin = Administrator.builder().build();

        admin.setId            ( id );
        admin.setUsername      ( USERNAME );
        admin.setPassword      ( PASSWORD );
        admin.setNickname      ( NICKNAME );
        admin.setEmail         ( EMAIL );
        admin.setSuccessfulAuth( SUCCESSFUL_AUTH );
        admin.setFailedAuth    ( FAILED_AUTH );
        admin.setLastConnection( lastConnection );
        admin.setReleaseBlock  ( releaseBlock );
        admin.setStatus        ( UserStatus.ACTIVE );
        admin.setAudit         ( null );

        assertThat( admin.getId()             ).isEqualTo( id );
        assertThat( admin.getUsername()       ).isEqualTo( USERNAME );
        assertThat( admin.getPassword()       ).isEqualTo( PASSWORD );
        assertThat( admin.getNickname()       ).isEqualTo( NICKNAME );
        assertThat( admin.getEmail()          ).isEqualTo( EMAIL );
        assertThat( admin.getSuccessfulAuth() ).isEqualTo( SUCCESSFUL_AUTH );
        assertThat( admin.getFailedAuth()     ).isEqualTo( FAILED_AUTH );
        assertThat( admin.getLastConnection() ).isEqualTo( lastConnection );
        assertThat( admin.getReleaseBlock()   ).isEqualTo( releaseBlock );
        assertThat( admin.getStatus()         ).isEqualTo( UserStatus.ACTIVE );
        assertThat( admin.getAudit()          ).isEqualTo( null );
    }

    @Test
    void adminBuilderTest() {
        UUID id = UUID.randomUUID();
        LocalDateTime lastConnection = LocalDateTime.now();
        LocalDateTime releaseBlock = LocalDateTime.now();

        Administrator admin = Administrator.builder()
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

        assertThat( admin.getId()             ).isEqualTo( id );
        assertThat( admin.getUsername()       ).isEqualTo( USERNAME );
        assertThat( admin.getPassword()       ).isEqualTo( PASSWORD );
        assertThat( admin.getNickname()       ).isEqualTo( NICKNAME );
        assertThat( admin.getEmail()          ).isEqualTo( EMAIL );
        assertThat( admin.getSuccessfulAuth() ).isEqualTo( SUCCESSFUL_AUTH );
        assertThat( admin.getFailedAuth()     ).isEqualTo( FAILED_AUTH );
        assertThat( admin.getLastConnection() ).isEqualTo( lastConnection );
        assertThat( admin.getReleaseBlock()   ).isEqualTo( releaseBlock );
        assertThat( admin.getStatus()         ).isEqualTo( UserStatus.ACTIVE );
        assertThat( admin.getAudit()          ).isEqualTo( null );
    }

}
