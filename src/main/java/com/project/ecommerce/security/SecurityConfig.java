package com.project.ecommerce.security;

import com.project.ecommerce.security.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // FE login + register
                        .requestMatchers("/auth/**").permitAll()

                        // Static files
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // API login
                        .requestMatchers("/api/auth/**").permitAll()

                        // Các API cần token
                        .requestMatchers("/api/**").authenticated()

                        // Cho phép mọi trang FE khác
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
