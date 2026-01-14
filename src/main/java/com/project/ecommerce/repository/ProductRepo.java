package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("""
                SELECT p FROM Product p
                WHERE p.category.id = :categoryId
                ORDER BY p.soldCount DESC
            """)
    List<Product> findFeaturedByCategory(
            @Param("categoryId") int categoryId,
            Pageable pageable
    );

    List<Product> findByCategoryId(int categoryId);
}
