package com.quathar.codebay.domain.usecase.mapper;

/**
 * <h1>Map From Value Object Use Case</h1>
 *
 * @param <V> The source type (Value Object) for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
public interface MapFromValueObjectUseCase<V, T> {

    /**
     * Converts an object of type V to an object of type T.
     *
     * @param valueObject The object to be converted to Target type.
     * @return An object of Target type.
     */
    T fromValueObject(V valueObject);

}
