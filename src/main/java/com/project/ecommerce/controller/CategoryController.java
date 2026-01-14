package com.project.ecommerce.controller;

import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public String productsByCategory(
            @PathVariable int id,
            Model model) {

        model.addAttribute("productList",
                productService.getProductsByCategory(id));

        return "productListByCategory";
    }

}
