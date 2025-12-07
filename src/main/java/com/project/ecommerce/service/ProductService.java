package com.project.ecommerce.service;

import com.project.ecommerce.dto.ProductManageDTO;

import java.util.List;

public interface ProductService {
  List<ProductManageDTO> findAll();
}
