package com.quathar.codebay.infra.jpa.embeddable.mapper.shop;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.shop.BankCard;
import com.quathar.codebay.infra.jpa.embeddable.shop.BankCardEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Bank Card Mapper</h1>
 *
 * @see MapperServicePort
 * @see BankCard
 * @see BankCardEmbeddable
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface BankCardMapper extends MapperServicePort<BankCard, BankCardEmbeddable> {
}
