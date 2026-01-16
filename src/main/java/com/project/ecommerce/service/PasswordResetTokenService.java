package com.project.ecommerce.service;

import com.project.ecommerce.entity.PasswordResetToken;
import com.project.ecommerce.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface PasswordResetTokenService {
    String createResetToken(User user);
    PasswordResetToken findByToken(String token);
}
