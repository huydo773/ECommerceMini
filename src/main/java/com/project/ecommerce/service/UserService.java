package com.project.ecommerce.service;

import com.project.ecommerce.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByEmail(String email);
}
