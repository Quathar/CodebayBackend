package com.quathar.codebay.infra.jpa.adapter.shop;

import com.quathar.codebay.domain.model.shop.ShoppingCart;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.shop.ShoppingCartEntity;
import com.quathar.codebay.infra.jpa.mapper.shop.ShoppingCartMapper;
import com.quathar.codebay.infra.jpa.repository.shop.JpaShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Order Repository Adapter</h1>
 *
 * @see ShoppingCartRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see ShoppingCart
 * @see ShoppingCartEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaShoppingCartRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<ShoppingCart, ShoppingCartEntity, java.util.UUID>
       implements  ShoppingCartRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for ShoppingCart entities.
     */
    private final JpaShoppingCartRepository jpaCartRepository;
    /**
     * Mapper for converting between ShoppingCart and ShoppingCartEntity.
     */
    private final ShoppingCartMapper cartMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaShoppingCartRepositoryAdapter} with the specified JpaShoppingCartRepository.
     *
     * @param jpaCartRepository The JPA repository for ShoppingCart entities.
     */
    @Autowired
    public JpaShoppingCartRepositoryAdapter(JpaShoppingCartRepository jpaCartRepository, ShoppingCartMapper cartMapper) {
        super(jpaCartRepository, cartMapper);
        this.jpaCartRepository = jpaCartRepository;
        this.cartMapper        = cartMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<ShoppingCart> findByUsername(String username) {
        return this.jpaCartRepository
                .findByUsername(username)
                .map(this.cartMapper::toModel);
    }

}
