package com.quathar.codebay.infra.config;

import com.quathar.codebay.app.service.shop.OrderService;
import com.quathar.codebay.app.service.shop.ProductService;
import com.quathar.codebay.app.service.shop.ShoppingCartService;
import com.quathar.codebay.app.service.shop.WishListService;
import com.quathar.codebay.app.usecase.CreateModelUseCase;
import com.quathar.codebay.app.usecase.DeleteModelUseCase;
import com.quathar.codebay.app.usecase.ReadAllModelsUseCase;
import com.quathar.codebay.app.usecase.ReadModelUseCase;
import com.quathar.codebay.app.usecase.UpdateModelUseCase;
import com.quathar.codebay.app.usecase.shop.cart.AddProductToCartUseCase;
import com.quathar.codebay.app.usecase.shop.cart.BuyCartProductsUseCase;
import com.quathar.codebay.app.usecase.shop.cart.MoveProductToWishListUseCase;
import com.quathar.codebay.app.usecase.shop.cart.ReadCartByUsernameUseCase;
import com.quathar.codebay.app.usecase.shop.cart.RemoveProductFromCartUseCase;
import com.quathar.codebay.app.usecase.shop.cart.UpdateProductInCartUseCase;
import com.quathar.codebay.app.usecase.shop.order.ReadAllOrdersByUsernameUseCase;
import com.quathar.codebay.app.usecase.shop.product.BuyProductUseCase;
import com.quathar.codebay.app.usecase.shop.product.ReadAllProductsFilteredWithUseCase;
import com.quathar.codebay.app.usecase.shop.product.ReadProductByCodeUseCase;
import com.quathar.codebay.app.usecase.shop.wishlist.AddProductToWishListUseCase;
import com.quathar.codebay.app.usecase.shop.wishlist.MoveProductToCartUseCase;
import com.quathar.codebay.app.usecase.shop.wishlist.ReadWishListByUsernameUseCase;
import com.quathar.codebay.app.usecase.shop.wishlist.RemoveProductFromWishListUseCase;
import com.quathar.codebay.domain.port.out.shop.OrderRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ProductRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Shop Service Configuration</h1>
 *
 * @see ProductService
 * @see ShoppingCartService
 * @see WishListService
 * @see OrderService
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Configuration
public class ShopServiceConfig {

    @Bean
    public ProductService productService(
            ProductRepositoryPort  productRepository,
            CustomerRepositoryPort customerRepository,
            OrderRepositoryPort    orderRepository
    ) {
        return ProductService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(productRepository) )
                .readAllProductsFilteredWithUseCase( new ReadAllProductsFilteredWithUseCase(productRepository) )
                .readUseCase( new ReadModelUseCase<>(productRepository) )
                .readByCodeUseCase( new ReadProductByCodeUseCase(productRepository) )
                .createUseCase( new CreateModelUseCase<>(productRepository) )
                .updateUseCase( new UpdateModelUseCase<>(productRepository) )
                .deleteUseCase( new DeleteModelUseCase<>(productRepository) )
                .buyProductUseCase( new BuyProductUseCase(productRepository, customerRepository, orderRepository) )
                .seal();
    }

    @Bean
    public ShoppingCartService shoppingCartService(
            ShoppingCartRepositoryPort cartRepository,
            ProductRepositoryPort      productRepository,
            CustomerRepositoryPort     customerRepository,
            WishListRepositoryPort     wishListRepository,
            OrderRepositoryPort        orderRepository
    ) {
        return ShoppingCartService.setup()
                .readCartByUsernameUseCase( new ReadCartByUsernameUseCase(cartRepository) )
                .addProductToCartUseCase( new AddProductToCartUseCase(cartRepository, productRepository) )
                .updateProductInCartUseCase( new UpdateProductInCartUseCase(cartRepository, productRepository) )
                .removeProductFromCartUseCase( new RemoveProductFromCartUseCase(cartRepository, productRepository) )
                .moveProductToWishListUseCase( new MoveProductToWishListUseCase(cartRepository, wishListRepository, productRepository) )
                .buyCartProductsUseCase( new BuyCartProductsUseCase(cartRepository, productRepository, customerRepository, orderRepository) )
                .seal();
    }

    @Bean
    public WishListService wishListService(
            WishListRepositoryPort     wishListRepository,
            ProductRepositoryPort      productRepository,
            ShoppingCartRepositoryPort cartRepository
    ) {
        return WishListService.setup()
                .readWishListByUsernameUseCase( new ReadWishListByUsernameUseCase(wishListRepository) )
                .addProductToWishListUseCase( new AddProductToWishListUseCase(wishListRepository, productRepository) )
                .removeProductFromWishListUseCase( new RemoveProductFromWishListUseCase(wishListRepository, productRepository) )
                .moveProductToCartUseCase( new MoveProductToCartUseCase(wishListRepository, cartRepository, productRepository) )
                .seal();
    }

    @Bean
    public OrderService orderService(OrderRepositoryPort orderRepository) {
        return OrderService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(orderRepository) )
                .readAllOrdersByUsernameUseCase( new ReadAllOrdersByUsernameUseCase(orderRepository) )
                .readUseCase( new ReadModelUseCase<>(orderRepository) )
                .createUseCase( new CreateModelUseCase<>(orderRepository) )
                .updateUseCase( new UpdateModelUseCase<>(orderRepository) )
                .deleteUseCase( new DeleteModelUseCase<>(orderRepository) )
                .seal();
    }

}
