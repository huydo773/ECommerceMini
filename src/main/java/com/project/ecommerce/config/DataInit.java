package com.project.ecommerce.config;

import com.project.ecommerce.entity.Category;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.Role;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.CategoryRepo;
import com.project.ecommerce.repository.ProductRepo;
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
    CommandLineRunner initUsers(UserRepo userRepo, RoleRepo roleRepo, ProductRepo productRepo, CategoryRepo categoryRepo) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setRoleName("Admin");
                roleRepo.save(adminRole);

                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRole(adminRole);
                userRepo.save(user);
            }

            if (userRepo.findByUsername("user").isEmpty()) {
                Role userRole = new Role();
                userRole.setRoleName("User");
                roleRepo.save(userRole);

                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole(userRole);
                userRepo.save(user);
            }

            //Tao product
            Product product1 = new Product();
            product1.setProductName("PC gaming");
            product1.setDescription("TuyetVoi");
            product1.setPrice(50.0);
            product1.setQuantity(3);
            product1.setImage("https://th.bing.com/th/id/OIP.8vV5DxsTNqVwrxbQ1Vw_swHaHa?w=169&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7");
            Category category1 = new Category();
            category1.setCategoryName("PC");
            categoryRepo.save(category1);
            product1.setCategory(category1);
            productRepo.save(product1);


            Product product2 = new Product();
            product2.setProductName("Lenovo LOQ 2024");
            product2.setDescription("Fantastic");
            product2.setPrice(40.0);
            product2.setQuantity(5);
            product2.setImage("https://th.bing.com/th/id/OIP.gH5DgPZjsxgemckNwlR1bAHaGk?w=204&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7");
            Category category2 = new Category();
            category2.setCategoryName("Laptop");
            categoryRepo.save(category2);
            product2.setCategory(category2);
            productRepo.save(product2);
        };
    }
}
