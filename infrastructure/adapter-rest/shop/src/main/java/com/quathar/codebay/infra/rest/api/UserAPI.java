package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.rest.api.crud.*;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;
import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.BaseAPI.BASE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>User API</h1>
 * <br>
 * <p>
 *     This interface defines the endpoints related to user operations.
 * </p>
 *
 * @since 2023-12-12
 * @version 1.0
 * @author Q
 */
@RequestMapping(UserAPI.ROOT)
public interface UserAPI
        extends RetrieveModelEndpoint<BasicUserResponse>,
                CreateModelEndpoint<CreateUserRequest, BasicUserResponse>,
                UpdateModelEndpoint<UpdateUserRequest, BasicUserResponse>,
                DeleteModelEndpoint {

    /**
     * The root path for user management API.
     */
    String ROOT = BASE_URL + "/users";

    /**
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/profile", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<BasicUserResponse> getProfile(HttpServletRequest request);


    @PostMapping(value = "/sign-up",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseEntity<BasicUserResponse> create(
            @RequestBody @Valid
            CreateUserRequest requestBody,
            BindingResult bindingResult
    );

}
