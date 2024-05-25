package com.quathar.codebay.infra.jpa.mapper.shop;

import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.embeddable.mapper.AuditMapper;
import com.quathar.codebay.infra.jpa.embeddable.mapper.shop.ImageMapper;
import com.quathar.codebay.infra.jpa.entity.shop.ProductEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Product Mapper</h1>
 *
 * @see MapperServicePort
 * @see Product
 * @see ProductEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = {
        ImageMapper.class,
        AuditMapper.class
})
public interface ProductMapper extends MapperServicePort<Product, ProductEntity> {
}
