package com.quathar.codebay.app.rest.shop.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpWishListResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicWishListResponse;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.WishList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Stream;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic Wish List Response Mapper</h1>
 *
 * @see HttpWishListResponseMapper
 * @see BasicWishListResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface BasicWishListResponseMapper extends HttpWishListResponseMapper<BasicWishListResponse> {

    // <<-FUNCTION->>
    /**
     * A function that maps a stream of {@link Product} objects to a stream of product codes (as {@link String}).
     */
    java.util.function.Function<
            Stream<Product>,
            Stream<String>
    > mapProducts = products -> java.util.Optional
            .ofNullable(products)
            .map(productStream -> productStream.map(Product::getCode))
            .orElseGet(Stream::of);

    // <<-METHOD->>
    @Override
    @Mapping(source = "customer.username", target = "username")
    @Mapping(target = "productCodes", expression = "java(mapProducts.apply( model.getProducts() ))")
    BasicWishListResponse fromModel(WishList model);

}
