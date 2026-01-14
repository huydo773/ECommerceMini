package com.project.ecommerce.service.impl;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.mapper.CategoryMapper;
import com.project.ecommerce.repository.CategoryRepo;
import com.project.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<CategoryDTO> getFeaturedCategories() {
        return categoryRepo.findAll()
                .stream()
                .map(categoryMapper::toCategoryDTO)
                .toList();
    }
}
