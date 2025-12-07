package com.project.ecommerce.service.impl;

import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.mapper.ProductMapper;
import com.project.ecommerce.repository.ProductRepo;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductManageDTO> findAll() {
        List<Product> products = productRepo.findAll();
        List<ProductManageDTO> productManageDTOs = productMapper.toProductManageDTO(products);
        return productManageDTOs;
    }
}
