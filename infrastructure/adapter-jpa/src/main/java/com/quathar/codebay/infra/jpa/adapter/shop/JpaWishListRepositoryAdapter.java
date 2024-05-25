package com.quathar.codebay.infra.jpa.adapter.shop;

import com.quathar.codebay.domain.model.shop.WishList;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;
import com.quathar.codebay.infra.jpa.adapter.JpaCrudRepositoryAdapter;
import com.quathar.codebay.infra.jpa.entity.shop.WishListEntity;
import com.quathar.codebay.infra.jpa.mapper.shop.WishListMapper;
import com.quathar.codebay.infra.jpa.repository.shop.JpaWishListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Wish List Repository Adapter</h1>
 *
 * @see WishListRepositoryPort
 * @see JpaCrudRepositoryAdapter
 * @see WishList
 * @see WishListEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaWishListRepositoryAdapter
       extends     JpaCrudRepositoryAdapter<WishList, WishListEntity, java.util.UUID>
       implements  WishListRepositoryPort {

    // <<-FIELDS->>
    /**
     * The JPA repository for WishList entities.
     */
    private final JpaWishListRepository jpaWishListRepository;
    /**
     * Mapper for converting between WishList and WishListEntity.
     */
    private final WishListMapper wishListMapper;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code JpaWishListRepositoryAdapter} with the specified {@code JpaWishListRepository}.
     *
     * @param jpaWishListRepository The JPA repository for WishList entities.
     */
    @Autowired
    public JpaWishListRepositoryAdapter(JpaWishListRepository jpaWishListRepository, WishListMapper wishListMapper) {
        super(jpaWishListRepository, wishListMapper);
        this.jpaWishListRepository = jpaWishListRepository;
        this.wishListMapper        = wishListMapper;
    }

    // <<-METHOD->>
    @Override
    public java.util.Optional<WishList> findByUsername(String username) {
        return this.jpaWishListRepository
                .findByUsername(username)
                .map(this.wishListMapper::toModel);
    }

}
