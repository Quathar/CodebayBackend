package com.quathar.codebay.infra.rest.admin.controller;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.infra.rest.admin.api.AuthminAPI;
import com.quathar.codebay.infra.rest.model.request.EmailAuthRequest;
import com.quathar.codebay.infra.rest.model.request.UsernameAuthRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * <h1>Admin Auth Controller</h1>
 * <br>
 * <p>
 *     Controller handling admin authentication-related endpoints.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public class AuthminController implements AuthminAPI {

    // <<-FIELD->>
    private final AuthServicePort authServicePort;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AuthminController(AuthServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    // <<-METHODS->>
    @Override
    public ResponseEntity<TokenPair> authByUsername(UsernameAuthRequest authRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        TokenPair tokenPair = this.authServicePort.authAdminByEmail(
                authRequest.username(),
                authRequest.password()
        );
        return ResponseEntity.ok().body(tokenPair);
    }

    @Override
    public ResponseEntity<TokenPair> authByEmail(EmailAuthRequest authRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        TokenPair tokenPair = this.authServicePort.authAdminByEmail(
                authRequest.email(),
                authRequest.password()
        );
        return ResponseEntity.ok().body(tokenPair);
    }

}
