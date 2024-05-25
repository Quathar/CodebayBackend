package com.quathar.codebay.infra.jpa.mapper.shop;

import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.shop.WishListEntity;
import com.quathar.codebay.infra.jpa.mapper.CustomerMapper;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Wish List Mapper</h1>
 *
 * @see MapperServicePort
 * @see WishList
 * @see WishListEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = {
        CustomerMapper.class,
        ProductMapper.class
})
public interface WishListMapper extends MapperServicePort<WishList, WishListEntity> {
}
