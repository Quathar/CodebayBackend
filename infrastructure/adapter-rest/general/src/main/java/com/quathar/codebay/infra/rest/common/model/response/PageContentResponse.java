package com.quathar.codebay.infra.rest.common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * <h1>Page Content Response</h1>
 *
 * Represents a response containing a paginated set of content of type M.
 *
 * @param <T> The type of content within the response.
 *
 * @param pageIndex The page number of the content.
 * @param pageSize  The size of each page.
 * @param content   The set of content for the specified page.
 *
 * @since 2023-12-21
 * @version 1.0
 * @author Q
 */
public record PageContentResponse<T>(
        @JsonInclude(NON_NULL)
        @JsonProperty("page")
        Integer pageIndex,
        @JsonProperty("size")
        Integer pageSize,
        java.util.List<T> content
) {}
