package com.quathar.codebay.infra.rest.admin.api;

import com.quathar.codebay.infra.rest.api.BaseAPI;

/**
 * <h1>Admin API (Application Programming Interface)</h1>
 * <br>
 * <p>
 *     This interface defines endpoints and functionalities specific to administrative tasks within the application.
 *     It operates under the '/api/v1/admin' base URL.
 * </p>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public interface AdminAPI {

    /**
     * Base URL for the admin API endpoints.
     */
    String BASE_URL = BaseAPI.BASE_URL + "/admin";

}
