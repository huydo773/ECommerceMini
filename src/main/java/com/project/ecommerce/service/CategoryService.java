package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getFeaturedCategories();
}
