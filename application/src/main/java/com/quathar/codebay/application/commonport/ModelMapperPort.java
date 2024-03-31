package com.quathar.codebay.application.commonport;

import com.quathar.codebay.domain.usecase.mapper.MapFromModelUseCase;
import com.quathar.codebay.domain.usecase.mapper.MapToModelUseCase;

/**
 * <h1>Model Mapper Port</h1>
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
public interface ModelMapperPort<M, T> extends MapToModelUseCase<T, M>, MapFromModelUseCase<M, T> {
}
