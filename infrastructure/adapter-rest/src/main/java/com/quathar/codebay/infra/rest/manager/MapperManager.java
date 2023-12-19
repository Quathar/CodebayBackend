package com.quathar.codebay.infra.rest.manager;

import com.quathar.codebay.infra.rest.model.mapper.BasicUserResponseMapper;
import com.quathar.codebay.infra.rest.model.mapper.CreateUserRequestMapper;
import com.quathar.codebay.infra.rest.model.mapper.UpdateUserRequestMapper;

/**
 * <h1>Mapper Manager</h1>
 * <br>
 * <p>
 *     Manages and provides instances of different mappers.<br>
 *     <br>
 *     This abstract class serves as a manager for various mapper instances.
 *     It allows retrieval of specific mapper instances based on the provided Class.
 * </p>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public abstract class MapperManager {

    /**
     * Retrieves an instance of the specified mapper class.
     *
     * @param clazz The Class representing the desired mapper.
     * @param <P>   The type of the mapper.
     * @return An instance of the requested mapper class, if available; otherwise, null.
     */
    public static <P> P getInstance(Class<P> clazz) {
        return clazz.cast(createInstance(clazz));
    }

    /**
     * Creates an instance of the specified mapper class.
     *
     * @param clazz The Class representing the desired mapper.
     * @return An instance of the requested mapper class, if available; otherwise, null.
     */
    private static Object createInstance(Class<?> clazz) {
        return switch (clazz.getSimpleName()) {
            case "CreateUserRequestMapper" -> CreateUserRequestMapper.getInstance();
            case "UpdateUserRequestMapper" -> UpdateUserRequestMapper.getInstance();
            case "BasicUserResponseMapper" -> BasicUserResponseMapper.getInstance();
            default -> null;
        };
    }

}
