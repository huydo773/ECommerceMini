package com.project.ecommerce.service.impl;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.dto.ProductListDTO;
import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Category;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.mapper.CategoryMapper;
import com.project.ecommerce.mapper.ProductMapper;
import com.project.ecommerce.repository.CategoryRepo;
import com.project.ecommerce.repository.ProductRepo;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Page<ProductManageDTO> getProductsForAdmin(String keyword, int page, int size,String sortType,String category,String quantityFilter) {
        Sort sort = Sort.unsorted();


        if ("cheap".equals(sortType)) {
            sort = Sort.by("price").ascending(); // giá rẻ nhất
        } else if ("stock".equals(sortType)) {
            sort = Sort.by("quantity").descending(); // tồn kho nhiều nhất
        }

        Pageable pageable = PageRequest.of(page, size,sort);
        Page<Product> productPage =
                productRepo.filterProducts(
                        keyword,
                        category,
                        "low".equals(quantityFilter) ? 4 : null,
                        "available".equals(quantityFilter),
                        "out".equals(quantityFilter),
                        pageable
                );
        return productPage.map(productMapper::toProductManageDTO);
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Map<CategoryDTO, List<ProductListDTO>> getFeaturedProductsForHome() {

        Map<CategoryDTO, List<ProductListDTO>> result = new LinkedHashMap<>();

        List<Category> categories = categoryRepo.findAll();

        for (Category c : categories) {

            List<ProductListDTO> products = productRepo
                    .findFeaturedByCategory(
                            c.getId(),
                            PageRequest.of(0, 8)
                    )
                    .stream()
                    .map(ProductMapper::toProductListDTO)
                    .toList();

            if (!products.isEmpty()) {
                result.put(categoryMapper.toCategoryDTO(c), products);
            }
        }

        return result;
    }

    @Override
    public List<ProductListDTO> getProductsByCategory(int categoryId) {
        return productRepo.findByCategoryId(categoryId)
                .stream()
                .map(ProductMapper::toProductListDTO)
                .toList();
    }

    @Override
    public ProductDetailDTO getProductDetail(int id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductMapper.toProductDetailDTO(product);
    }

}
