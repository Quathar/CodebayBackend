package com.quathar.codebay.domain.port.out.option;

import com.quathar.codebay.domain.port.out.CrudRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.BaseOption;

/**
 * <h1>Base Option Repository Port</h1>
 *
 * @param <M> The base option parent type value object
 *
 * @see CrudRepositoryPort
 * @see BaseOption
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
public interface BaseOptionRepositoryPort<M extends BaseOption>
       extends   CrudRepositoryPort<M, String> {

    /**
     * Retrieves a stream of base option parent type value objects.
     *
     * @return A stream of value objects.
     */
    java.util.stream.Stream<M> findAll();

}
