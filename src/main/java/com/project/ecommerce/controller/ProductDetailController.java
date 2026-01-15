package com.project.ecommerce.controller;

import com.project.ecommerce.dto.ProductDetailDTO;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        ProductDetailDTO product = productService.getProductDetail(id);
        model.addAttribute("product", product);
        return "product-detail";
    }
}
