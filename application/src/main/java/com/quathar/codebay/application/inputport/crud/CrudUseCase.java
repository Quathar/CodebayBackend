package com.quathar.codebay.application.inputport.crud;

/**
 * <h1>CRUD Use Cases</h1>
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
public interface CrudUseCase<M, ID> extends CreateModelUseCase<M>, ReadModelUseCase<M, ID>, UpdateModelUseCase<M>, DeleteModelUseCase<ID> {
}
