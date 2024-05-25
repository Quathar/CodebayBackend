package com.quathar.codebay.infra.jpa.adapter.shop;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.shop.ProductEntity;
import com.quathar.codebay.infra.jpa.mapper.shop.ProductMapper;
import com.quathar.codebay.infra.jpa.repository.shop.JpaProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Product Repository Adapter</h1>
 *
 * @see ProductRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see Product
 * @see ProductEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaProductRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<Product, ProductEntity, java.util.UUID>
       implements  ProductRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for Product entities.
     */
    private final JpaProductRepository jpaProductRepository;
    /**
     * Mapper for converting between Product and ProductEntity.
     */
    private final ProductMapper productMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaProductRepositoryAdapter} with the specified JpaProductRepository.
     *
     * @param jpaProductRepository The JPA repository for Product entities.
     */
    @Autowired
    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository, ProductMapper productMapper) {
        super(jpaProductRepository, productMapper);
        this.jpaProductRepository = jpaProductRepository;
        this.productMapper        = productMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.stream.Stream<Product> findWithFilters(ProductFilters filters) {
        var pageRequest = PageRequest.of(filters.getPageIndex(), filters.getPageSize());
        return this.jpaProductRepository
                .findAllByFilters(pageRequest, filters)
                .stream()
                .map(this.productMapper::toModel);
    }

    @Override
    public java.util.Optional<Product> findByCode(String code) {
        return this.jpaProductRepository
                .findByCode(code)
                .map(this.productMapper::toModel);
    }

}
