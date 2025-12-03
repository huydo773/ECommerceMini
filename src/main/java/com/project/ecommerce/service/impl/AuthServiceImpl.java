package com.project.ecommerce.service.impl;

import com.project.ecommerce.dto.RegisterDTO;
import com.project.ecommerce.entity.Role;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.mapper.UserMapper;
import com.project.ecommerce.repository.RoleRepo;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public String login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElse(null);

        if (user == null) return null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) return null;

        return jwtUtil.generateToken(username);
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        if (userRepo.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        User user = userMapper.toUser(registerDTO);
        Role role = roleRepo.findRoleById(2);
        user.setRole(role);
        return userRepo.save(user);
    }

}
