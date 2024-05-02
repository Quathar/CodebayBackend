package com.quathar.codebay.domain.port.out.mapper;

/**
 * <h1>Mapper Service Port</h1>
 *
 * This interface defines mapping operations between two types: M (Model) and T (Target).
 *
 * @param <M> The model type for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public interface MapperServicePort<M, T> extends MapToModel<T, M>, MapFromModel<M, T> {
}
