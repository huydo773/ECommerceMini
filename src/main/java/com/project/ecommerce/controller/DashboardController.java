package com.project.ecommerce.controller;

import com.project.ecommerce.dto.ProductManageDTO;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;
import com.project.ecommerce.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String dashboardPage(Model model) {
        model.addAttribute("totalUsers",statisticService.countAllUser());
        return "dashboard"; // dashboard.html
    }

    @GetMapping("/productManagement")
    public String productPage(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "sortType",required = false) String sortType,
            @RequestParam(value="category",required = false) String category,
            @RequestParam(value="quantityFilter",required = false) String quantityFilter,
            Model model) {

        if (category != null && category.isBlank()) {
            category = null;
        }


        if (keyword != null && keyword.isBlank()) {
            keyword = null;
        }

        Page<ProductManageDTO> productPage =
                productService.getProductsForAdmin(keyword, page, size,sortType,category,quantityFilter);

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortType", sortType);
        model.addAttribute("category", category);
        model.addAttribute("quantityFilter", quantityFilter);

        return "productManagement";
    }

    @GetMapping("/order")
    public String orderPage(Model model) {
        return "order";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        return "user";
    }

    @GetMapping("/voucher")
    public String voucherPage(Model model) {
        return "voucher";
    }
}
