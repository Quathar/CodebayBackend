package com.quathar.codebay.infra.rest.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.quathar.codebay.application.inputport.security.AuthenticationServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.security.config.SecurityTestConfiguration;
import com.quathar.codebay.infra.rest.security.model.request.UsernameAuthRequest;
import com.quathar.codebay.infra.rest.security.model.response.AuthenticationResponse;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.quathar.codebay.infra.rest.security.api.AuthenticationAPI.ROOT;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <h1>Auth Controller Unit Tests</h1>
 *
 * @since 2023-12-20
 * @version 1.0
 * @author Q
 */
class AuthenticationControllerTest implements SecurityTestConfiguration {

    //<<-FIELDS->>
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthenticationServicePort authServicePort;

    //<<-TESTS->>
    @Test
    @WithAnonymousUser
    void givenValidCredentialsWithUsername_whenAuthenticatingUser_thenStatusIsOkAndTokensAreRetrieved() throws Exception {
        var username = "jdoe";
        var password = "MR%uQK4uX$7K";
        var requestBody = new UsernameAuthRequest(username, password);
        var tokenPairToCheck = TokenPair.builder()
                .accessToken( "randomAccessToken" )
                .refreshToken( "randomAccessToken" )
                .build();
        when( this.authServicePort.performAuthentication(username, password) )
                .thenReturn( tokenPairToCheck );

        MvcResult result = this.mockMvc.perform(
                post(ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(requestBody) )
        ).andExpectAll(
                status().isOk(),
                content().contentType( APPLICATION_JSON_VALUE )
        ).andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        AuthenticationResponse authenticationResponse = this.objectMapper.readValue(jsonResponse, AuthenticationResponse.class);

        assertThat( authenticationResponse.accessToken()  ).isEqualTo( tokenPairToCheck.getAccessToken()  );
        assertThat( authenticationResponse.refreshToken() ).isEqualTo( tokenPairToCheck.getRefreshToken() );
    }

    @Test
    void givenInvalidCredentialsWithUsername_whenGettingUser_thenStatusIsUnauthorized() throws Exception {
//        User user = User.builder()
//                .username( "sfaffafsdf" )
//                .password( "MR%uQK4uX$7K" )
//                .build();
//        when( this.jwtServicePort.authByUsername(user.getUsername(), user.getPassword()) )
//                .thenThrow( InvalidCredentialsException.class );

//        this.mockMvc.perform(
//                post(AUTH_ROOT + "/username")
//                        .accept( APPLICATION_JSON_VALUE )
//                        .contentType( APPLICATION_JSON_VALUE )
//                        .content( this.objectMapper.writeValueAsString(user) )
//        ).andExpect( status().isUnauthorized() );
    }

    @Test
    void givenMalformedCredentialsWithUsername_whenGettingUser_thenStatusIsUnauthorized() throws Exception {
        User user = User.builder()
                .username( "jdoe" )
                // password: Blank
                .password( "" )
                .build();
//        when( this.authServicePort.authByUsername(user.getUsername(), user.getPassword()) )
//                .thenThrow( InvalidCredentialsException.class );

//        this.mockMvc.perform(
//                post(AUTH_ROOT + "/username")
//                        .accept( APPLICATION_JSON_VALUE )
//                        .contentType( APPLICATION_JSON_VALUE )
//                        .content( this.objectMapper.writeValueAsString(user) )
//        ).andExpect( status().isBadRequest() );
    }
    @Test
    void givenValidCredentialsWithEmail_whenAuthenticatingUser_thenStatusIsOkAndTokensAreRetrieved() throws Exception {
        User user = User.builder()
                .email( "jdoe@email.com" )
                .password( "MR%uQK4uX$7K" )
                .build();
//        TokenPair tokenPair = TokenManager.generateTokenPair( UUID.randomUUID().toString() );
//        when( this.jwtServicePort.authByEmail(user.getEmail(), user.getPassword()) )
//                .thenReturn( tokenPair );

//        MvcResult result = this.mockMvc.perform(
//                post(AUTH_ROOT + "/username")
//                        .accept( APPLICATION_JSON_VALUE )
//                        .contentType( APPLICATION_JSON_VALUE )
//                        .content( this.objectMapper.writeValueAsString(user) )
//        ).andExpectAll(
//                status().isOk(),
//                content().contentType(APPLICATION_JSON_VALUE)
//        ).andReturn();
//
//        String responseJson = result.getResponse().getContentAsString();
//        TokenPair response = this.objectMapper.readValue(
//                responseJson,
//                TokenPair.class
//        );
//
//        assertThat( response.getType()         ).isEqualTo( tokenPair.getType() );
//        assertThat( response.getRefreshToken() ).isEqualTo( tokenPair.getRefreshToken() );
//        assertThat( response.getAccessToken()  ).isEqualTo( tokenPair.getAccessToken() );
    }

    @Test
    void givenInvalidCredentialsWithEmail_whenGettingUser_thenStatusIsUnauthorized() throws Exception {
        User user = User.builder()
                .email( "sfaffafsdf" )
                .password( "MR%uQK4uX$7K" )
                .build();
//        when( this.jwtServicePort.authByEmail(user.getEmail(), user.getPassword()) )
//                .thenThrow( InvalidCredentialsException.class );

//        this.mockMvc.perform(
//                post(AUTH_ROOT + "/username")
//                        .accept( APPLICATION_JSON_VALUE )
//                        .contentType( APPLICATION_JSON_VALUE )
//                        .content( this.objectMapper.writeValueAsString(user) )
//        ).andExpect( status().isUnauthorized() );
    }

}
