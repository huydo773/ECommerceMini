package com.project.ecommerce.config;

import com.project.ecommerce.entity.Role;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.RoleRepo;
import com.project.ecommerce.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInit {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    CommandLineRunner initUsers(UserRepo userRepo, RoleRepo roleRepo) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setRoleName("Admin");
                roleRepo.save(adminRole);

                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRole(adminRole);  // gán role đã lưu
                userRepo.save(user);
            }

            // Tạo user mặc định
            if (userRepo.findByUsername("user").isEmpty()) {
                Role userRole = new Role();
                userRole.setRoleName("User");
                roleRepo.save(userRole);

                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole(userRole);  // gán role đã lưu
                userRepo.save(user);
            }
        };
    }
}
