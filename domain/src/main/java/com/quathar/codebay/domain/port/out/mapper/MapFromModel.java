package com.quathar.codebay.domain.port.out.mapper;

/**
 * <h1>Map From Model Service Port</h1>
 *
 * @param <M> The source type (Model) for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface MapFromModel<M, T> {

    /**
     * Converts an object of type M to an object of type T.
     *
     * @param model The object to be converted to Target type.
     * @return An object of Target type.
     */
    T fromModel(M model);

}
