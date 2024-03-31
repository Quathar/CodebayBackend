package com.quathar.codebay.domain.usecase.mapper;

/**
 * <h1>Map To Model Use Case</h1>
 *
 * @param <T> The source type for mapping.
 * @param <M> The target type (Model) for mapping.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface MapToModelUseCase<T, M> {

    /**
     * Converts an object of type T to an object of type M.
     *
     * @param other The object to be converted to Model type.
     * @return An object of Model type.
     */
    M toModel(T other);

}
