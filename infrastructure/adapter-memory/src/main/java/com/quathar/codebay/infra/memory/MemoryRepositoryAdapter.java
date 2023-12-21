package com.quathar.codebay.infra.memory;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;

import java.util.Optional;

/**
 * <h1>Memory Repository Adapter</h1>
 * <br>
 * <p>
 *     Adapter implementing the CrudRepositoryPort interface using an in-memory data store.
 * </p>
 *
 * @param <M>  The domain model type.
 * @param <ID> The domain model identifier type.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public class MemoryRepositoryAdapter<M, ID> implements CrudRepositoryPort<M, ID> {

    // <<-FIELD->>
    /**
     * In-memory repository for domain models.
     */
    protected final  java.util.Map<ID, M> memoryRepository;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs the Memory Repository Adapter with an empty in-memory repository.
     */
    protected MemoryRepositoryAdapter() {
        this.memoryRepository = new java.util.HashMap<>();
    }

    // <<-METHODS->>
    @Override
    public java.util.List<M> findAll(int size, int number) {
        return this.memoryRepository.values()
                .stream()
                .limit(size)
                .toList();
    }

    @Override
    public Optional<M> findById(ID id) {
        return Optional.of(
                this.memoryRepository.get(id)
        );
    }

    @Override
    public M save(M model) {
        // Implement in each subclass
        // Implement in each subclass
        // Implement in each subclass
        return null;
    }

    @Override
    public M update(M model) {
        // Implement in each subclass
        // Implement in each subclass
        // Implement in each subclass
        return null;
    }

    @Override
    public Boolean deleteById(ID id) {
        M model = this.memoryRepository.remove(id);
        return model != null;
    }

}
