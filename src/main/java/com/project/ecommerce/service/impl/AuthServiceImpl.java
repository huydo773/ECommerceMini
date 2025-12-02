package com.project.ecommerce.service.impl;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.UserRepo;
import com.project.ecommerce.security.jwt.JwtUtil;
import com.project.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;



    @Override
    public String login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElse(null);

        if (user == null) return null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) return null;

        return jwtUtil.generateToken(username);
    }
}
