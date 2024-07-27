package com.quathar.codebay.infra.jpa.adapter.security;

import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.port.out.security.OperationRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.security.OperationEntity;
import com.quathar.codebay.infra.jpa.mapper.security.OperationMapper;
import com.quathar.codebay.infra.jpa.repository.security.JpaOperationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Operation Repository Adapter</h1>
 *
 * @see OperationRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see Operation
 * @see OperationEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaOperationRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<Operation, OperationEntity, java.util.UUID>
       implements  OperationRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for Operation entities.
     */
    private final JpaOperationRepository jpaOperationRepository;
    /**
     * Mapper for converting between {@link Operation} and {@link OperationEntity}.
     */
    private final OperationMapper operationMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaOperationRepositoryAdapter} for the {@link OperationRepositoryPort}
     * with the specified {@link JpaOperationRepository} and {@link OperationMapper}.
     *
     * @param jpaOperationRepository The JPA repository for {@link OperationEntity}.
     * @param operationMapper        The mapper for converting between {@link Operation} and {@link OperationEntity}.
     */
    @Autowired
    public JpaOperationRepositoryAdapter(JpaOperationRepository jpaOperationRepository, OperationMapper operationMapper) {
        super(jpaOperationRepository, operationMapper);
        this.jpaOperationRepository = jpaOperationRepository;
        this.operationMapper        = operationMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<Operation> findByName(String operationName) {
        return this.jpaOperationRepository
                .findByName(operationName)
                .map(this.operationMapper::toModel);
    }

}
