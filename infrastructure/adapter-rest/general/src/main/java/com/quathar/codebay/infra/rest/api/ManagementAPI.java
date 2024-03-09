package com.quathar.codebay.infra.rest.api;

import static com.quathar.codebay.infra.rest.api.BaseAPI.BASE_URL;

/**
 * <h1>Management API (Application Programming Interface)</h1>
 * <br>
 * <p>
 *     This interface defines endpoints and functionalities specific to administrative tasks within the application.
 *     It operates under the '/api/v1/management' base URL.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public interface ManagementAPI {

    /**
     * Base URL for the admin API endpoints.
     */
    String MANAGE_URL = BASE_URL + "/management";

}
