package com.quathar.codebay.application.commonport;

import java.util.Set;

/**
 * <h1>Model Mapper</h1>
 * <br>
 * <p>
 *     This interface defines mapping operations between two types: M (Model) and T (Target).
 * </p>
 *
 * @param <M> The source type (Model) for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface ModelMapper<M, T> {

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

    /**
     * Converts a Set of objects from type T to a Set of objects of type M.
     *
     * @param otherSet The Set of objects to be converted to Model type.
     * @return A Set of objects of Model type.
     */
    Set<M> toModelSet(Set<T> otherSet);

    /**
     * Converts a Set of objects from type M to a Set of objects of type T.
     *
     * @param modelSet The Set of models to be converted to Target type.
     * @return A Set of objects of Target type.
     */
    Set<T> fromModelSet(Set<M> modelSet);

}
