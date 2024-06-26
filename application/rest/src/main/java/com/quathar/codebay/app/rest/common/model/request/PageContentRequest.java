package com.quathar.codebay.app.rest.common.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Page Content Request</h1>
 *
 * Represents a request for content retrieval with pagination details.
 *
 * @param page The page index for content retrieval. Must be a non-negative integer.
 * @param size The size of each page for content retrieval. Must be an integer between 1 and 100 (inclusive).
 *
 * @since 2023-12-21
 * @version 1.0
 * @author Q
 */
public record PageContentRequest(
        @NotNull
        @Min(value = 0)
        Integer page,
        @NotNull
        @Min(value = 1)
        @Max(value = 100)
        Integer size
) {}
