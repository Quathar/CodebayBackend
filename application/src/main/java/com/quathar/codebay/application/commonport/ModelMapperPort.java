package com.quathar.codebay.application.commonport;

import java.util.Collection;

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

    /**
     * Converts a collection of objects from type T to a collection of objects of type M.
     *
     * @param otherCollection The collection of objects to be converted to Model type.
     * @return A collection of objects of Model type.
     */
    Collection<M> toModelCollection(Collection<T> otherCollection);

    /**
     * Converts a collection of objects from type M to a collection of objects of type T.
     *
     * @param modelCollection The collection of models to be converted to Target type.
     * @return A collection of objects of Target type.
     */
    Collection<T> fromModelCollection(Collection<M> modelCollection);

}
