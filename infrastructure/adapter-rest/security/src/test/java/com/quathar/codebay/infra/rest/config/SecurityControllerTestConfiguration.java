package com.quathar.codebay.infra.rest.config;

import com.quathar.codebay.infra.rest.controller.ShopAuthController;
import com.quathar.codebay.infra.rest.controller.AuthControllerAdvice;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * <h1>Controller Test Configuration</h1>
 * <br>
 * <p>
 *     This abstract class serves as a general configuration for testing controllers,
 *     specifically designed for the UserController as of the current implementation.
 *     It includes necessary configurations for exception handling through ExceptionControllerAdvice.
 * </p>
 *
 * @since 2023-12-16
 * @version 1.0
 * @author Q
 */
//@Import({AuthInputAdapterConfiguration.class})
@WebMvcTest
@ContextConfiguration(classes = {
        AuthControllerAdvice.class,
        ShopAuthController.class
})
public abstract class SecurityControllerTestConfiguration {

    // TODO: Before the module restructre the test were passed
    // TODO: Now there is a problem with the Repositories
    // TODO: Fix it

}
