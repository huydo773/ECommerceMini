package com.project.ecommerce.repository;

import com.project.ecommerce.entity.PasswordResetToken;
import com.project.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepo extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUser(User user);
}
