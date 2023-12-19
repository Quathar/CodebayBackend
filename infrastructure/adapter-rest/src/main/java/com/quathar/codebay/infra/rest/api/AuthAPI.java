package com.quathar.codebay.infra.rest.api;

import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.infra.rest.model.request.EmailAuthRequest;
import com.quathar.codebay.infra.rest.model.request.UsernameAuthRequest;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h1>Authentication API</h1>
 * <br>
 * <p>
 *     API endpoints for authentication.
 * </p>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
@RequestMapping(BaseAPI.BASE_URL + "/auth")
public interface AuthAPI {

    /**
     * Authenticate using a username.
     *
     * @param authRequest The authentication request containing username and password.
     * @return A response entity with authentication details.
     */
    @PostMapping("/username")
    ResponseEntity<TokenPair> authByUsername(
            @RequestBody @Valid
            UsernameAuthRequest authRequest,
            BindingResult bindingResult);

    /**
     * Authenticate using an email address.
     *
     * @param authRequest The authentication request containing email and password.
     * @return A response entity with authentication details.
     */
    @PostMapping("/email")
    ResponseEntity<TokenPair> authByEmail(
            @RequestBody @Valid
            EmailAuthRequest authRequest,
            BindingResult bindingResult);

}
