package com.project.ecommerce.service.impl;

import com.project.ecommerce.entity.PasswordResetToken;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.PasswordResetTokenRepo;
import com.project.ecommerce.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Autowired
    private PasswordResetTokenRepo passwordResetTokenRepo;

    @Override
    public String createResetToken(User user) {
        PasswordResetToken tokenExisted = passwordResetTokenRepo.findByUser(user);
        if (tokenExisted != null) {
            passwordResetTokenRepo.delete(tokenExisted);
        }
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(1));
        passwordResetTokenRepo.save(resetToken);
        return token;
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepo.findByToken(token) ;
    }
}
