package com.project.ecommerce.controller;


import com.project.ecommerce.dto.LoginDTO;
import com.project.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        String token = authService.login(dto.getUserName(), dto.getPassword());

        if (token == null) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        return ResponseEntity.ok(Map.of("token", token));
    }
}
