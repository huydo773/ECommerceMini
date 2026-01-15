package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.dto.ProductListDTO;
import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductManageDTO> getProductsForAdmin();

    Product getProductById(int id);

    Map<CategoryDTO, List<ProductListDTO>> getFeaturedProductsForHome();

    List<ProductListDTO> getProductsByCategory(int categoryId);

    ProductDetailDTO getProductDetail(int id);
}
