package com.quathar.codebay.infra.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.util.TokenManager;
import com.quathar.codebay.domain.exception.InvalidCredentialsException;
import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.config.ControllerTestConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.AuthAPI.AUTH_ROOT;

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
public class AuthControllerTest extends ControllerTestConfiguration {

    //<<-FIELDS->>
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private AuthServicePort authServicePort;

    //<<-CONSTRUCTOR->>
    @Autowired
    public AuthControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc      = mockMvc;
        this.objectMapper = objectMapper;
    }

    //<<-TESTS->>
    @Test
    void givenValidCredentialsWithUsername_whenAuthenticatingUser_thenStatusIsOkAndTokensAreRetrieved() throws Exception {
        User user = User.builder()
                .username( "jdoe" )
                .password( "MR%uQK4uX$7K" )
                .build();
        TokenPair tokenPair = TokenManager.generateTokenPair( UUID.randomUUID().toString() );
        when( this.authServicePort.authByUsername(user.getUsername(), user.getPassword()) )
                .thenReturn( tokenPair );

        MvcResult result = this.mockMvc.perform(
                post(AUTH_ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpectAll(
                status().isOk(),
                content().contentType(APPLICATION_JSON_VALUE)
        ).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        TokenPair response = this.objectMapper.readValue(
                responseJson,
                TokenPair.class
        );

        assertThat( response.getType()         ).isEqualTo( tokenPair.getType() );
        assertThat( response.getRefreshToken() ).isEqualTo( tokenPair.getRefreshToken() );
        assertThat( response.getAccessToken()  ).isEqualTo( tokenPair.getAccessToken() );
    }

    @Test
    void givenInvalidCredentialsWithUsername_whenGettingUser_thenStatusIsUnauthorized() throws Exception {
        User user = User.builder()
                .username( "sfaffafsdf" )
                .password( "MR%uQK4uX$7K" )
                .build();
        when( this.authServicePort.authByUsername(user.getUsername(), user.getPassword()) )
                .thenThrow( InvalidCredentialsException.class );

        this.mockMvc.perform(
                post(AUTH_ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpect( status().isUnauthorized() );
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

        this.mockMvc.perform(
                post(AUTH_ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpect( status().isBadRequest() );
    }
    @Test
    void givenValidCredentialsWithEmail_whenAuthenticatingUser_thenStatusIsOkAndTokensAreRetrieved() throws Exception {
        User user = User.builder()
                .email( "jdoe@email.com" )
                .password( "MR%uQK4uX$7K" )
                .build();
        TokenPair tokenPair = TokenManager.generateTokenPair( UUID.randomUUID().toString() );
        when( this.authServicePort.authByEmail(user.getEmail(), user.getPassword()) )
                .thenReturn( tokenPair );

        MvcResult result = this.mockMvc.perform(
                post(AUTH_ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpectAll(
                status().isOk(),
                content().contentType(APPLICATION_JSON_VALUE)
        ).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        TokenPair response = this.objectMapper.readValue(
                responseJson,
                TokenPair.class
        );

        assertThat( response.getType()         ).isEqualTo( tokenPair.getType() );
        assertThat( response.getRefreshToken() ).isEqualTo( tokenPair.getRefreshToken() );
        assertThat( response.getAccessToken()  ).isEqualTo( tokenPair.getAccessToken() );
    }

    @Test
    void givenInvalidCredentialsWithEmail_whenGettingUser_thenStatusIsUnauthorized() throws Exception {
        User user = User.builder()
                .email( "sfaffafsdf" )
                .password( "MR%uQK4uX$7K" )
                .build();
        when( this.authServicePort.authByEmail(user.getEmail(), user.getPassword()) )
                .thenThrow( InvalidCredentialsException.class );

        this.mockMvc.perform(
                post(AUTH_ROOT + "/username")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpect( status().isUnauthorized() );
    }

}
