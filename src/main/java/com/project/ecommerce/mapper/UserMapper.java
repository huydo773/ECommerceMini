package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.RegisterDTO;
import com.project.ecommerce.dto.UserDTO;
import com.project.ecommerce.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoleName(user.getRole().getRoleName());
        return userDTO;
    }
    public User toUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUserName());
        user.setEmail(registerDTO.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        return user;
    }

}
