package com.quathar.codebay.app.usecase.security.authentication;

import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * <h1>Authentication Use Case Implementation Test</h1>
 *
 * @see AuthenticationUseCase
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class AuthenticationUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private AuthenticationManagerPort authenticationManagerPort;
    @InjectMocks
    private AuthenticationUseCase authenticationUseCase;

    // <<-TEST->>
    @Test
    void GivenCredentials_WhenAuthenticate_thenPerformAuthenticationIsInvokedOnce() {
        // [Given]
        var authKey  = "user";
        var password = "pass";

        // [When]
        this.authenticationUseCase.authenticate(authKey, password);

        // [Then]
        verify(this.authenticationManagerPort, only()  ).performAuthentication(authKey, password);
    }

}
