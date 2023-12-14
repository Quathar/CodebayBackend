package com.quathar.codebay.application.inputport;

import com.quathar.codebay.application.usecase.crud.CreateModelUseCase;
import com.quathar.codebay.application.usecase.crud.DeleteModelUseCase;
import com.quathar.codebay.application.usecase.crud.ReadModelUseCase;
import com.quathar.codebay.application.usecase.crud.UpdateModelUseCase;

/**
 * <h1>CRUD Service Port</h1>
 * <br>
 * <p>
 *     Contract for the basic CRUD <b>use cases</b>:
 * </p>
 * <ul>
 *     <li>Create</li>
 *     <li>Read</li>
 *     <li>Update</li>
 *     <li>Delete</li>
 * </ul>
 *
 * @param <M> The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface CrudServicePort<M, ID> extends CreateModelUseCase<M>, ReadModelUseCase<M, ID>, UpdateModelUseCase<M>, DeleteModelUseCase<ID> {
}
