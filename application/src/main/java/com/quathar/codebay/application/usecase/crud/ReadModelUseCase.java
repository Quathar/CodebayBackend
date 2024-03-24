package com.quathar.codebay.application.usecase.crud;

/**
 * <h1>Read Model Use Case</h1>
 *
 * This interface defines methods to retrieve domain models and collections of domain models.
 *
 * @param <M> The domain model
 * @param <ID> The domain model identifier type
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface ReadModelUseCase<M, ID>  {

    /**
     * Retrieves a collection of domain models with pagination support.
     *
     * @param pageIndex The page index.
     * @param pageSize  The number of items per page.
     * @return A list of domain models within the specified page and size.
     */
    java.util.List<M> getAll(int pageIndex, int pageSize);

    /**
     * Retrieves a domain model based on its identifier.
     *
     * @param id The identifier of the domain model to retrieve.
     * @return The retrieved domain model.
     */
    M getById(ID id);

}
