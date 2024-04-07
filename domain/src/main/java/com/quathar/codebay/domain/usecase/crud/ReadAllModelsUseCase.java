package com.quathar.codebay.domain.usecase.crud;

/**
 * <h1>Read All Models Use Case</h1>
 *
 * @param <M> The domain model
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface ReadAllModelsUseCase<M> {

    /**
     * Retrieves a collection of domain models with pagination support.
     *
     * @param pageIndex The page index.
     * @param pageSize  The number of items per page.
     * @return A list of domain models within the specified page and size.
     */
    java.util.List<M> getAll(int pageIndex, int pageSize);

}
