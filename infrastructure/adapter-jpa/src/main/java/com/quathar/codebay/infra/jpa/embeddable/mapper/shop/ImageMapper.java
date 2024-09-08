package com.quathar.codebay.infra.jpa.embeddable.mapper.shop;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.shop.Image;
import com.quathar.codebay.infra.jpa.embeddable.shop.ImageEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Image Mapper</h1>
 *
 * @see MapperServicePort
 * @see Image
 * @see ImageEmbeddable
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface ImageMapper extends MapperServicePort<Image, ImageEmbeddable> {
}
