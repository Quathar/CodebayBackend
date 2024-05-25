package com.quathar.codebay.infra.jpa.embeddable.mapper.shop;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.shop.Address;
import com.quathar.codebay.infra.jpa.embeddable.shop.AddressEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Address Mapper</h1>
 *
 * @see MapperServicePort
 * @see Address
 * @see AddressEmbeddable
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface AddressMapper extends MapperServicePort<Address, AddressEmbeddable> {
}
