package com.project.ecommerce.dto;

import com.project.ecommerce.entity.Role;

public class UserDTO {
    private int id;
    private String username;
    private String email;
    private String roleName;


    public UserDTO() {
    }

    public UserDTO(String username, String email, String roleName) {
        this.username = username;
        this.email = email;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
