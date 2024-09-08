package com.quathar.codebay.app.service.shop;

import com.quathar.codebay.app.service.CrudService;
import com.quathar.codebay.domain.model.shop.Order;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.domain.port.in.shop.product.BuyProductUseCasePort;
import com.quathar.codebay.domain.port.in.shop.product.ReadAllProductsFilteredWithUseCasePort;
import com.quathar.codebay.domain.port.in.shop.product.ReadByCodeUseCasePort;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * <h1>Product Service</h1>
 *
 * @see CrudService
 * @see ReadAllProductsFilteredWithUseCasePort
 * @see ReadByCodeUseCasePort
 * @see BuyProductUseCasePort
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class ProductService
       extends     CrudService<Product, java.util.UUID>
       implements  ReadAllProductsFilteredWithUseCasePort,
                   ReadByCodeUseCasePort,
                   BuyProductUseCasePort {

    // <<-FIELDS->>
    @NonNull private final ReadAllProductsFilteredWithUseCasePort readAllProductsFilteredWithUseCase;
    @NonNull private final ReadByCodeUseCasePort                  readByCodeUseCase;
    @NonNull private final BuyProductUseCasePort                  buyProductUseCase;

    // <<-METHODS->>
    @Override
    public java.util.stream.Stream<Product> getAllFilteredWith(ProductFilters filters) {
        return this.readAllProductsFilteredWithUseCase.getAllFilteredWith(filters);
    }

    @Override
    public Product getByCode(String code) {
        return this.readByCodeUseCase.getByCode(code);
    }

    @Override
    public Order buyProduct(String username, String code, int units) {
        return this.buyProductUseCase.buyProduct(username, code, units);
    }

}
