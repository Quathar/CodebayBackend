package com.quathar.codebay.infra.outputadapter.jpa;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.application.commonport.ModelMapper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <h1>JPA (Java Persistence API) Repository Adapter</h1>
 * <br>
 * <p>
 *     This class serves as an adapter implementing the CrudRepositoryPort interface,
 *     connecting a JpaRepository with a ModelMapper for CRUD operations.
 * </p>
 *
 * @param <M>  The source type (Model) for mapping.
 * @param <T>  The target type (Entity) for mapping.
 * @param <ID> The type of the entity identifier.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public class JpaRepositoryAdapter<M, T, ID> implements CrudRepositoryPort<M, ID>  {

    // <<-FIELD->>
    /**
     * The JPA repository to perform database operations.
     */
    private final JpaRepository<T, ID> jpaRepository;
    /**
     * The model mapper for converting between Model and Entity types.
     */
    private final ModelMapper<M, T> modelMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a JpaRepositoryAdapter with the provided JPA repository and model mapper.
     *
     * @param jpaRepository The JPA Repository for database operations.
     * @param modelMapper   The ModelMapper for mapping between Model and Entity types.
     */
    public JpaRepositoryAdapter(JpaRepository<T, ID> jpaRepository, ModelMapper<M, T> modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper   = modelMapper;
    }

    // <<-METHODS->>
    @Override
    public Optional<M> findById(ID id) {
        return this.jpaRepository.findById(id).map(this.modelMapper::toModel);
    }

    @Override
    public M save(M model) {
        return this.modelMapper.toModel(
                this.jpaRepository.save(
                        this.modelMapper.fromModel(model)
                )
        );
    }

    @Override
    public M update(M model) {
        return this.modelMapper.toModel(
                this.jpaRepository.save(
                        this.modelMapper.fromModel(model)
                )
        );
    }

    @Override
    public Boolean deleteById(ID id) {
        if (id != null) {
            this.jpaRepository.deleteById(id);
            return true;
        } else return false;
    }

}
