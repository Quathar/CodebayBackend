package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.rest.api.crud.*;
import com.quathar.codebay.infra.rest.model.request.CreateUserRequest;
import com.quathar.codebay.infra.rest.model.request.UpdateUserRequest;
import com.quathar.codebay.infra.rest.model.response.BasicUserResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.quathar.codebay.infra.rest.api.ManagementAPI.MANAGE_URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Administrator API</h1>
 * <br>
 * <p>
 *     This interface defines the endpoints related to admin operations.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(AdminAPI.ROOT)
public interface AdminAPI
       extends RetrieveModelEndpoint<Administrator>,
               CreateModelEndpoint<CreateUserRequest, Administrator>,
               UpdateModelEndpoint<UpdateUserRequest, Administrator>,
               DeleteModelEndpoint {

    /**
     * The root path for admin management API.
     */
    String ROOT = MANAGE_URL + "/admins";

    /**
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/profile", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<BasicUserResponse> getProfile(HttpServletRequest request);


}
