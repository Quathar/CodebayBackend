package com.quathar.codebay.infra.rest.model.response;

/**
 * <h1>Page Content Response</h1>
 * <br>
 * <p>
 *     Represents a response containing a paginated set of content of type M.
 * </p>
 *
 * @param <T> The type of content within the response.
 *
 * @param pageIndex The page number of the content.
 * @param pageSize The size of each page.
 * @param content The set of content for the specified page.
 *
 * @since 2023-12-21
 * @version 1.0
 * @author Q
 */
public record PageContentResponse<T>(
        Integer pageIndex,
        Integer pageSize,
        java.util.List<T> content
) {}