package com.quathar.codebay.infra.jpa.mapper.shop;

import com.quathar.codebay.domain.model.shop.CartDetail;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.shop.CartDetailEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Cart Details Mapper</h1>
 *
 * @see MapperServicePort
 * @see CartDetail
 * @see CartDetailEmbeddable
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = ProductMapper.class)
public interface CartDetailMapper extends MapperServicePort<CartDetail, CartDetailEmbeddable> {
}
