package com.quathar.codebay.infra.jpa.adapter;

import com.quathar.codebay.domain.port.out.CrudRepositoryPort;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;

import lombok.AllArgsConstructor;

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
@AllArgsConstructor
public abstract class JpaCrudRepositoryAdapter<M, T, ID>
       implements     CrudRepositoryPort<M, ID> {

    // <<-FIELDS->>
    /**
     * The JPA repository for T entities.
     */
    private final JpaRepository<T, ID> jpaRepository;
    /**
     * Mapper for converting between M and T.
     */
    private final MapperServicePort<M, T> mapperService;

    // <<-METHODS->>
    @Override
    public java.util.stream.Stream<M> findAll(int pageIndex, int pageSize) {
        return this.jpaRepository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .map(this.mapperService::toModel)
                .stream();
    }

    @Override
    public java.util.Optional<M> findById(ID id) {
        return this.jpaRepository
                .findById(id)
                .map(this.mapperService::toModel);
    }

    @Override
    public M save(M model) {
        T entityToSave = this.mapperService.fromModel(model);
        T savedEntity  = this.jpaRepository.save(entityToSave);
        return this.mapperService.toModel(savedEntity);
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
