package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.UserDTO;
import com.project.ecommerce.entity.User;

public class UserMapper {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoleName(user.getRole().getRoleName());
        return userDTO;
    }

}
