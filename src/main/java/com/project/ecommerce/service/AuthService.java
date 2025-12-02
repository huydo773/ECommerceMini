package com.project.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login(String username,String password);

}
