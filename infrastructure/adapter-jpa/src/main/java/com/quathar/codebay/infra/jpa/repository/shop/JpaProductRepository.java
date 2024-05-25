package com.quathar.codebay.infra.jpa.repository.shop;

import com.quathar.codebay.domain.model.shop.ProductFilters;
import com.quathar.codebay.infra.jpa.entity.shop.ProductEntity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <h1>JPA (Java Persistence API) Product Repository</h1>
 *
 * @see ProductEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, java.util.UUID> {

    /**
     * Finds all {@link ProductEntity} objects that match the given filters.
     *
     * @param pageRequest The {@link PageRequest} object containing pagination information.
     * @param filters     The {@link ProductFilters} object containing various filtering criteria.
     * @return A collection of {@link ProductEntity} objects that match the specified filters.
     */
    @Query("""
        SELECT p FROM ProductEntity p
        WHERE
                (:#{#filters.code}         IS NULL OR :#{#filters.code} = '' OR p.code LIKE %:#{#filters.code}%)
            AND (:#{#filters.onSale}       IS NULL OR p.onSale  = :#{#filters.onSale})
            AND (:#{#filters.onOffer}      IS NULL OR p.onOffer = :#{#filters.onOffer})
            AND (:#{#filters.isNew}        IS NULL OR p.isNew   = :#{#filters.isNew})
            AND (:#{#filters.minPrice}     IS NULL OR p.price  >= :#{#filters.minPrice})
            AND (:#{#filters.maxPrice}     IS NULL OR p.price  <= :#{#filters.maxPrice})
            AND (:#{#filters.minRating}    IS NULL OR p.rating >= :#{#filters.minRating})
            AND (:#{#filters.maxRating}    IS NULL OR p.rating <= :#{#filters.maxRating})
            AND (:#{#filters.minStock}     IS NULL OR p.stock  >= :#{#filters.minStock})
            AND (:#{#filters.maxStock}     IS NULL OR p.rating <= :#{#filters.maxStock})
            AND (:#{#filters.minUnitsSold} IS NULL OR p.stock  >= :#{#filters.minUnitsSold})
            AND (:#{#filters.maxUnitsSold} IS NULL OR p.rating <= :#{#filters.maxUnitsSold})
            AND (:#{#filters.minDiscount}  IS NULL OR p.stock  >= :#{#filters.minDiscount})
            AND (:#{#filters.maxDiscount}  IS NULL OR p.rating <= :#{#filters.maxDiscount})
    """)
    java.util.Collection<ProductEntity> findAllByFilters(PageRequest pageRequest, @Param("filters") ProductFilters filters);

    /**
     * Finds a {@link ProductEntity} by its unique code.
     *
     * @param code The unique code of the product.
     * @return An optional containing the {@link ProductEntity} if found, or empty if not found.
     */
    java.util.Optional<ProductEntity> findByCode(String code);

}
