package com.quathar.codebay.infra.rest.api;

import org.springframework.web.bind.annotation.RequestMapping;

import static com.quathar.codebay.infra.rest.api.ManagementAPI.MANAGE_URL;

/**
 * <h1>Management Authentication API</h1>
 * <br>
 * <p>
 *     API endpoints for authentication on the management side.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(MANAGE_URL + "/auth")
public interface ManagementAuthAPI extends ShopAuthAPI {
}
