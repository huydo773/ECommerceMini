package com.project.ecommerce.controller;

import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.service.CategoryService;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/dashboard/product")
public class ProductCRUDController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {


        ProductManageDTO product = productService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getFeaturedCategories());


        return "product-edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute ProductManageDTO product, @RequestParam("imageFile") MultipartFile imageFile) {

        if (!imageFile.isEmpty()) {
            String fileName = productService.saveImage(imageFile);
            product.setProductImage(fileName);
        }

        productService.update(product);
        return "redirect:/dashboard/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/dashboard/products";
    }
}
