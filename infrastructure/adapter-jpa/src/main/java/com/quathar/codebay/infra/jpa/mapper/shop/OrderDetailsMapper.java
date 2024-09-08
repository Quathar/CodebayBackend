package com.quathar.codebay.infra.jpa.mapper.shop;

import com.quathar.codebay.domain.model.shop.OrderDetail;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.shop.OrderDetailEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Order Details Mapper</h1>
 *
 * @see MapperServicePort
 * @see OrderDetail
 * @see OrderDetailEmbeddable
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = ProductMapper.class)
public interface OrderDetailsMapper extends MapperServicePort<OrderDetail, OrderDetailEmbeddable> {
}
