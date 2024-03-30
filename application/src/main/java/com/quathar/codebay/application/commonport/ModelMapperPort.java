package com.quathar.codebay.application.commonport;

/**
 * <h1>Model Mapper Port</h1>
 *
 * This interface defines mapping operations between two types: M (Model) and T (Target).
 *
 * @param <M> The source type (Model) for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface ModelMapperPort<M, T> {

    /**
     * Converts an object of type T to an object of type M.
     *
     * @param other The object to be converted to Model type.
     * @return An object of Model type.
     */
    M toModel(T other);

    /**
     * Converts an object of type M to an object of type T.
     *
     * @param model The object to be converted to Target type.
     * @return An object of Target type.
     */
    T fromModel(M model);

}
