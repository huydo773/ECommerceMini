package com.project.ecommerce.service;

import com.project.ecommerce.dto.RegisterDTO;
import com.project.ecommerce.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login(String username,String password);
    User register(RegisterDTO registerDTO);
    void resetPassword(String token, String newPassword);
}
