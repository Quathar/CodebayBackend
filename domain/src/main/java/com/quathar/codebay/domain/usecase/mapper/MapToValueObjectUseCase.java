package com.quathar.codebay.domain.usecase.mapper;

/**
 * <h1>Map To Value Object Use Case</h1>
 *
 * @param <T> The source type for mapping.
 * @param <V> The target type (Value Object) for mapping.
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
public interface MapToValueObjectUseCase<T, V> {

    /**
     * Converts an object of type T to an object of type V.
     *
     * @param other The object to be converted to Value Object type.
     * @return An object of Value Object type.
     */
    V toValueObject(T other);

}
