package com.quathar.codebay.infra.rest.config;

import com.quathar.codebay.infra.rest.controller.ExceptionControllerAdvice;
import com.quathar.codebay.infra.rest.controller.UserController;

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
@WebMvcTest
@ContextConfiguration(classes = {
        ExceptionControllerAdvice.class,
        UserController.class
})
public abstract class ControllerTestConfiguration {
}
