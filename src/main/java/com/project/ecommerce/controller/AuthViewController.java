package com.project.ecommerce.controller;

import com.project.ecommerce.dto.RegisterDTO;
import com.project.ecommerce.service.AuthService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthViewController {

    @Autowired
    private AuthService authService;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        String token = authService.login(username, password);

        if (token == null) {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }

        return "dashboard"; // render dashboard.html
    }

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterDTO());
        return "register"; // register.html
    }

    // Xử lý submit form
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerRequest") RegisterDTO request,
                                  Model model) {
        try {
            authService.register(request);
            model.addAttribute("success", "Đăng ký thành công!");
            return "register"; // trở lại form nhưng có thông báo thành công
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("username", "Huy");
        model.addAttribute("products", List.of());
        return "dashboard";
    }
}
