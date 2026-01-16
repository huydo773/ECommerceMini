package com.project.ecommerce.service.impl;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.UserRepo;
import com.project.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
