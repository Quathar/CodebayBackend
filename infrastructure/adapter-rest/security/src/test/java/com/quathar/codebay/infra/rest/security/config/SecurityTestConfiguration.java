package com.quathar.codebay.infra.rest.security.config;

import com.quathar.codebay.infra.rest.security.controller.SecurityControllerAdvice;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * <h1>Controller Test Configuration</h1>
 *
 * This abstract class serves as a general configuration for testing controllers,
 * specifically designed for the UserController as of the current implementation.
 * It includes necessary configurations for exception handling through ExceptionControllerAdvice.
 *
 * @since 2023-12-16
 * @version 1.0
 * @author Q
 */
@WebMvcTest(excludeAutoConfiguration = SecurityAutoConfiguration.class)
@ContextConfiguration(classes = SecurityControllerAdvice.class)
public interface SecurityTestConfiguration {
}
