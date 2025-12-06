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

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterDTO());
        return "register"; // register.html
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerRequest") RegisterDTO request,
                                  Model model) {
        try {
            authService.register(request);
            model.addAttribute("success", "Đăng ký thành công!");
            return "register";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
