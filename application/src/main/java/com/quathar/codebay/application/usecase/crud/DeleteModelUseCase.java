package com.quathar.codebay.application.usecase.crud;

/**
 * <h1>Delete Model Use Case</h1>
 *
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface DeleteModelUseCase<ID>  {

    /**
     * Deletes a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to delete.
     * @return true if the deletion is successful, otherwise false.
     */
    Boolean deleteById(ID id);

}
