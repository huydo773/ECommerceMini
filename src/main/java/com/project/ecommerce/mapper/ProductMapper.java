package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.dto.ProductListDTO;
import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public ProductManageDTO toProductManageDTO(Product product) {
        ProductManageDTO productManageDTO = new ProductManageDTO();
        productManageDTO.setId(product.getId());
        productManageDTO.setProductCode(product.getProductCode());
        productManageDTO.setProductName(product.getProductName());
        productManageDTO.setProductDescription(product.getDescription());
        productManageDTO.setProductPrice(product.getPrice());
        productManageDTO.setProductQuantity(product.getQuantity());
        productManageDTO.setProductCategory(product.getCategory());
        productManageDTO.setProductImage(product.getImage());
        return productManageDTO;
    }

    public void updateProductFromDTO(ProductManageDTO dto,
                                     Product product) {
        if (dto == null || product == null) {
            return;
        }
        product.setProductCode(dto.getProductCode());
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getProductDescription());
        product.setPrice(dto.getProductPrice());
        product.setQuantity(dto.getProductQuantity());
        product.setImage(dto.getProductImage());
    }

    public List<ProductManageDTO> toProductManageDTO(List<Product> products) {
        List<ProductManageDTO> productManageDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductManageDTO productManageDTO = toProductManageDTO(product);
            productManageDTOs.add(productManageDTO);
        }
        return productManageDTOs;
    }

    public static ProductListDTO toProductListDTO(Product p) {
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setId(p.getId());
        productListDTO.setProductName(p.getProductName());
        productListDTO.setPrice(p.getPrice());
        productListDTO.setImage(p.getImage());
        return productListDTO;
    }

    public static ProductDetailDTO toProductDetailDTO(Product p) {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setId(p.getId());
        productDetailDTO.setName(p.getProductName());
        productDetailDTO.setPrice(p.getPrice());
        productDetailDTO.setDescription(p.getDescription());
        productDetailDTO.setQuantity(p.getQuantity());
        productDetailDTO.setImage(p.getImage());
        return productDetailDTO;
    }

}
