package com.quathar.codebay.domain.usecase.crud;

/**
 * <h1>Delete Model Use Case</h1>
 *
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface DeleteUseCase<ID>  {

    /**
     * Deletes a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to delete.
     */
    void deleteById(ID id);

}
