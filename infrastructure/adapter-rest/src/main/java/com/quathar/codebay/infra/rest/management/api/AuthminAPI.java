package com.quathar.codebay.infra.rest.management.api;

import com.quathar.codebay.infra.rest.api.AuthAPI;

import org.springframework.web.bind.annotation.RequestMapping;

import static com.quathar.codebay.infra.rest.management.api.ManagementAPI.MANAGE_URL;

/**
 * <h1>Administration Authentication API</h1>
 * <br>
 * <p>
 *     API endpoints for authentication on the admin side.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(MANAGE_URL + "/auth")
public interface AuthminAPI extends AuthAPI {
}
