package com.project.ecommerce.controller;

import com.project.ecommerce.service.ProductService;
import com.project.ecommerce.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String productPage(Model model) {
        model.addAttribute("products",productService.getProductsForAdmin());
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
