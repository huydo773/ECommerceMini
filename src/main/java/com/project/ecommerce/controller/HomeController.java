package com.project.ecommerce.controller;

import com.project.ecommerce.repository.ProductRepo;
import com.project.ecommerce.service.CategoryService;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("categoryList",categoryService.getFeaturedCategories());
        model.addAttribute("productList", productService.getFeaturedProductsForHome());
        return "home";
    }


}
