package com.quathar.codebay.infra.rest.config;

import com.quathar.codebay.infra.rest.conf.InputAdapterConfiguration;
import com.quathar.codebay.infra.rest.controller.AuthController;
import com.quathar.codebay.infra.rest.controller.ExceptionControllerAdvice;
import com.quathar.codebay.infra.rest.controller.UserController;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
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
@Import({InputAdapterConfiguration.class})
@WebMvcTest
@ContextConfiguration(classes = {
        ExceptionControllerAdvice.class,
        AuthController.class,
        UserController.class
})
public abstract class ControllerTestConfiguration {

    // TODO: Before the module restructre the test were passed
    // TODO: Now there is a problem with the Repositories
    // TODO: Fix it

}
