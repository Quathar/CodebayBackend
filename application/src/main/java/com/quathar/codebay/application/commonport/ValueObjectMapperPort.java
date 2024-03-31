package com.quathar.codebay.application.commonport;

import com.quathar.codebay.domain.usecase.mapper.MapFromValueObjectUseCase;
import com.quathar.codebay.domain.usecase.mapper.MapToValueObjectUseCase;

/**
 * <h1>Value Object Mapper Port</h1>
 *
 * This interface defines mapping operations between two types: V (Value Object) and T (Target).
 *
 * @param <V> The source type (Value Object) for mapping.
 * @param <T> The target type for mapping.
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
public interface ValueObjectMapperPort<V, T> extends MapToValueObjectUseCase<T, V>, MapFromValueObjectUseCase<V, T> {
}
