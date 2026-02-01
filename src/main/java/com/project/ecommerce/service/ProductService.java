package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.dto.ProductListDTO;
import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Page<ProductManageDTO> getProductsForAdmin(String keyword, int page, int size,String sortType,String category,String quantityFilter);

    ProductManageDTO getProductById(int id);

    Map<CategoryDTO, List<ProductListDTO>> getFeaturedProductsForHome();

    List<ProductListDTO> getProductsByCategory(int categoryId);

    ProductDetailDTO getProductDetail(int id);

    void update(ProductManageDTO product);

    void delete(int id);

    String saveImage(MultipartFile imageFile);

    void addProduct(ProductManageDTO productManageDTO, MultipartFile imageFile) throws IOException;
}
