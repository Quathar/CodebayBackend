package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.OperationEntity;
import com.quathar.codebay.infra.jpa.mapper.security.OperationMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaOperationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Operation Repository Adapter</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public class      JpaOperationRepositoryAdapter
       extends    JpaCrudRepositoryAdapter<Operation, OperationEntity, java.util.UUID>
       implements OperationRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for Operation entities.
     */
    private final JpaOperationRepository jpaOperationRepository;
    /**
     * Mapper for converting between Operation and OperationEntity.
     */
    private final OperationMapper operationMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaOperationRepositoryAdapter} with the specified JpaOperationRepository.
     *
     * @param jpaOperationRepository The JPA repository for Operation entities.
     */
    @Autowired
    public JpaOperationRepositoryAdapter(JpaOperationRepository jpaOperationRepository) {
        super(jpaOperationRepository, OperationMapper.INSTANCE);
        this.jpaOperationRepository = jpaOperationRepository;
        this.operationMapper        = OperationMapper.INSTANCE;
    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<Operation> findByName(String operationName) {
        return this.jpaOperationRepository
                .findByName(operationName)
                .map(this.operationMapper::toModel);
    }

}
