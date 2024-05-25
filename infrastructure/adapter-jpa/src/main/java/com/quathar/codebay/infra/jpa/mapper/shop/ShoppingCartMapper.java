package com.quathar.codebay.infra.jpa.mapper.shop;

import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.shop.ShoppingCartEntity;

import com.quathar.codebay.infra.jpa.mapper.CustomerMapper;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Shopping Cart Mapper</h1>
 *
 * @see MapperServicePort
 * @see ShoppingCart
 * @see ShoppingCartEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = {
        CustomerMapper.class,
        CartDetailMapper.class
})
public interface ShoppingCartMapper extends MapperServicePort<ShoppingCart, ShoppingCartEntity> {
}
