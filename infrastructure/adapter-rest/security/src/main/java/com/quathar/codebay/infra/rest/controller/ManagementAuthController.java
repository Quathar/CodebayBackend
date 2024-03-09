package com.quathar.codebay.infra.rest.controller;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.domain.model.TokenPair;
import com.quathar.codebay.infra.rest.api.ManagementAuthAPI;
import com.quathar.codebay.infra.rest.model.request.EmailAuthRequest;
import com.quathar.codebay.infra.rest.model.request.UsernameAuthRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Management Authentication Controller</h1>
 * <br>
 * <p>
 *     Controller handling admin authentication-related endpoints.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RestController
public class ManagementAuthController implements ManagementAuthAPI {

    // <<-FIELD->>
    private final AuthServicePort authServicePort;

    // <<-CONSTRUCTOR->>
    @Autowired
    public ManagementAuthController(AuthServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    // <<-METHODS->>
    @Override
    public ResponseEntity<TokenPair> authByUsername(UsernameAuthRequest authRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();
        TokenPair tokenPair = this.authServicePort.authAdminByUsername(
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
