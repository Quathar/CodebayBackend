package com.quathar.codebay.infra.rest.common.factory;

import com.quathar.codebay.infra.rest.common.model.response.PageContentResponse;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Common Factory</h1>
 *
 * This interface provides methods for creating common HTTP-related objects.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpCommonFactory {

    /**
     * Creates a {@link PageContentResponse} object.
     *
     * @param <M> The type of the content list.
     *
     * @param pageIndex The index of the page.
     * @param pageSize  The size of the page.
     * @param content   The content of the page.
     * @return A {@link PageContentResponse} object containing the provided content.
     */
    static <M> PageContentResponse<M> getPageContentResponse(
            Integer pageIndex,
            Integer pageSize,
            java.util.List<M> content
    ) {
        return new PageContentResponse<>(pageIndex, pageSize, content);
    }

}
