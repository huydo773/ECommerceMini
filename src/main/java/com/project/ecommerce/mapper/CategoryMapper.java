package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CategoryDTO;
import com.project.ecommerce.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getCategoryName());
        return categoryDTO;
    }
}
