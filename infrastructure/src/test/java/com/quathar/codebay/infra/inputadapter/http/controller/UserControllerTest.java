package com.quathar.codebay.infra.inputadapter.http.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.inputadapter.config.ControllerTestConfiguration;
import com.quathar.codebay.infra.inputadapter.http.api.UserAPI;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <h1>User Controller Unit Tests</h1>
 *
 * @since 2023-12-16
 * @version 1.0
 * @author Q
 */
class UserControllerTest extends ControllerTestConfiguration {

    //<<-FIELDS->>
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private UserServicePort userServicePort;

    //<<-CONSTRUCTOR->>
    @Autowired
    public UserControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc      = mockMvc;
        this.objectMapper = objectMapper;
    }

    //<<-TESTS->>
    @Test
    void givenRandomId_whenGettingUser_thenStatusIs404() throws Exception {
        UUID id = UUID.randomUUID();
        when( this.userServicePort.getById(id) ).thenThrow( ResourceNotFoundException.class );

        this.mockMvc.perform(
                get(UserAPI.USER_ROOT + "/{id}", id)
                        .accept( APPLICATION_JSON_VALUE )
        ).andExpect( status().isNotFound() );
    }

    @Test
    void givenKnownId_whenGettingUser_thenUserIsRetrievedSuccessfully() throws Exception {
        UUID id = UUID.randomUUID();
        User user = User.builder()
                .id( id )
                .username( "jdoe" )
                .password( "MR%uQK4uX$7K" )
                .nickname( "John Doe" )
                .email( "jdoe@email.com" )
                .build();
        when( this.userServicePort.getById(id) ).thenReturn( user );

        MvcResult result = this.mockMvc.perform(
                get(UserAPI.USER_ROOT + "/{id}", id)
                        .accept( APPLICATION_JSON_VALUE )
        ).andExpectAll(
                status().isOk(),
                content().contentType( APPLICATION_JSON_VALUE )
        ).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        User responseUser = this.objectMapper.readValue(
                responseJson,
                User.class
        );

        assertThat( responseUser.getId()       ).isNotNull();
        assertThat( responseUser.getUsername() ).isEqualTo( user.getUsername() );
        assertThat( responseUser.getNickname() ).isEqualTo( user.getNickname() );
        assertThat( responseUser.getEmail()    ).isEqualTo( user.getEmail() );
    }

    @Test
    void givenInvalidUserDetails_whenCreatingUser_thenStatusIs400() throws Exception {
        User user = User.builder()
                .username( "jdoe" )
                // password: Blank
                .password( "" )
                // nickname: Null
//                .nickname( "John Doe" )
                // email: Bad Pattern
                .email( "jdoe email.com" )
                .build();

        this.mockMvc.perform(
                post(UserAPI.USER_ROOT + "/sign-up")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .characterEncoding( UTF_8 )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpect( status().isBadRequest() );
    }

    @Test
    void givenValidUserDetails_whenCreatingUser_thenUserIsSuccessfullyCreated() throws Exception {
        User user = User.builder()
                .username( "jdoe" )
                .password( "MR%uQK4uX$7K" )
                .nickname( "John Doe" )
                .email( "jdoe@email.com" )
                .build();
        User serviceRetrievedUser = User.builder()
                .id( UUID.randomUUID() )
                .username( user.getUsername() )
                .password( user.getPassword() )
                .nickname( user.getNickname() )
                .email( user.getEmail() )
                .build();

        when( this.userServicePort.create(user) ).thenReturn( serviceRetrievedUser );

        MvcResult result = this.mockMvc.perform(
                post(UserAPI.USER_ROOT + "/sign-up")
                        .accept( APPLICATION_JSON_VALUE )
                        .contentType( APPLICATION_JSON_VALUE )
                        .characterEncoding( UTF_8 )
                        .content( this.objectMapper.writeValueAsString(user) )
        ).andExpectAll(
                status().isCreated(),
                content().contentType( APPLICATION_JSON_VALUE )
        ).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        User responseUser = this.objectMapper.readValue(
                responseJson,
                User.class
        );

        assertThat( responseUser.getId()       ).isNotNull();
        assertThat( responseUser.getUsername() ).isEqualTo( user.getUsername() );
        assertThat( responseUser.getNickname() ).isEqualTo( user.getNickname() );
        assertThat( responseUser.getEmail()    ).isEqualTo( user.getEmail() );
    }

}
