package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("""
                SELECT p FROM Product p
                WHERE p.category.id = :categoryId
                ORDER BY p.soldCount DESC
            """)
    Page<Product> findFeaturedByCategory(
            @Param("categoryId") int categoryId,
            Pageable pageable
    );

    List<Product> findByCategoryId(int categoryId);

    @Query("""
            SELECT p FROM Product p
            WHERE (:keyword IS NULL
            OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')))
            AND (:category IS NULL
            OR p.category.categoryName = :category)
            AND (
            (:lowStock IS NOT NULL AND p.quantity > 0 AND p.quantity < :lowStock)
            OR (:lowStock IS NULL AND :available = true AND p.quantity > 0)
            OR (:lowStock IS NULL AND :outOfStock = true AND p.quantity = 0)
            OR (:lowStock IS NULL AND :available = false AND :outOfStock = false)
            )
            """)
    Page<Product> filterProducts(
            @Param("keyword") String keyword,
            @Param("category") String category,
            @Param("lowStock") Integer lowStock,
            @Param("available") boolean available,
            @Param("outOfStock") boolean outOfStock,
            Pageable pageable
    );

    int countByProductCodeStartingWith(String prefix);

    boolean existsByProductCode(String productCode);
}
