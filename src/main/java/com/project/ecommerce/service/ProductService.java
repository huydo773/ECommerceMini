package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.dto.ProductListDTO;
import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Page<ProductManageDTO> getProductsForAdmin(String keyword, int page, int size,String sortType,String category,String quantityFilter);

    Product getProductById(int id);

    Map<CategoryDTO, List<ProductListDTO>> getFeaturedProductsForHome();

    List<ProductListDTO> getProductsByCategory(int categoryId);

    ProductDetailDTO getProductDetail(int id);

}
