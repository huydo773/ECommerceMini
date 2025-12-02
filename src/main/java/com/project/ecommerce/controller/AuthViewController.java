package com.project.ecommerce.controller;

import com.project.ecommerce.service.AuthService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("username", "Huy");
        model.addAttribute("products", List.of());
        return "dashboard";
    }
}
