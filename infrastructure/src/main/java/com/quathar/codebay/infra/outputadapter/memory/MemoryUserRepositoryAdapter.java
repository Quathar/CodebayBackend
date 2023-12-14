package com.quathar.codebay.infra.outputadapter.memory;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.User;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * <h1>Memory User Repository Adapter</h1>
 * <br>
 * <p>
 *     Adapter implementing the UserRepositoryPort interface using an in-memory data store.
 * </p>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Component
public class MemoryUserRepositoryAdapter extends MemoryRepositoryAdapter<User, UUID> implements UserRepositoryPort {

    // <<-CONSTRUCTOR->>
    public MemoryUserRepositoryAdapter() {
        super();
    }

    // <<-METHODS->>
    @Override
    public User save(User model) {
        UUID id = UUID.randomUUID();
        model.setId(id);
        this.memoryRepository.put(id, model);
        return model;
    }

    @Override
    public User update(User model) {
        User user = this.memoryRepository.get(model.getId());
        if (user == null)
            throw new ResourceNotFoundException();
        this.memoryRepository.put(model.getId(), model);
        return model;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        // TODO: Not implemented
        // TODO: Not implemented
        // TODO: Not implemented
        return Optional.empty();
    }
}
