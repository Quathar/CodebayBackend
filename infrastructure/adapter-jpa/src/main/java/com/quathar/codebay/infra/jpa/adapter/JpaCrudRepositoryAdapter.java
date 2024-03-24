package com.quathar.codebay.infra.jpa.adapter;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;
import com.quathar.codebay.application.commonport.ModelMapperPort;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>JPA (Java Persistence API) CRUD Repository Adapter</h1>
 *
 * This class serves as an adapter implementing the CrudRepositoryPort interface,
 * connecting a JpaRepository with a ModelMapper for CRUD operations.
 *
 * @param <M>  The source type (Model) for mapping.
 * @param <T>  The target type (Entity) for mapping.
 * @param <ID> The type of the entity identifier.
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
public class JpaCrudRepositoryAdapter<M, T, ID> implements CrudRepositoryPort<M, ID>  {

    // <<-FIELDS->>
    /**
     * The JPA repository to perform database operations.
     */
    private final JpaRepository<T, ID> jpaRepository;
    /**
     * The model mapper for converting between Model and Entity types.
     */
    private final ModelMapperPort<M, T> modelMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a JPA Repository Adapter with the provided JPA repository and model mapper.
     *
     * @param jpaRepository The JPA Repository for database operations.
     * @param modelMapper   The ModelMapper for mapping between Model and Entity types.
     */
    public JpaCrudRepositoryAdapter(JpaRepository<T, ID> jpaRepository, ModelMapperPort<M, T> modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper   = modelMapper;
    }

    // <<-METHODS->>
    @Override
    public java.util.List<M> findAll(int pageIndex, int pageSize) {
        return this.jpaRepository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .map(this.modelMapper::toModel)
                .toList();
    }

    @Override
    public java.util.Optional<M> findById(ID id) {
        return this.jpaRepository.findById(id).map(this.modelMapper::toModel);
    }

    @Override
    public M save(M model) {
        T entityToSave = this.modelMapper.fromModel(model);
        T savedEntity  = this.jpaRepository.save(entityToSave);
        return this.modelMapper.toModel(savedEntity);
    }

    @Override
    public M update(M model) {
        return this.save(model);
    }

    @Override
    public void deleteById(ID id) {
        this.jpaRepository.deleteById(id);
    }

}
