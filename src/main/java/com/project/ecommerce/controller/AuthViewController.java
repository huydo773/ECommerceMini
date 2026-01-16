package com.project.ecommerce.controller;

import com.project.ecommerce.dto.MailDTO;
import com.project.ecommerce.dto.RegisterDTO;
import com.project.ecommerce.entity.PasswordResetToken;
import com.project.ecommerce.entity.User;
import com.project.ecommerce.service.AuthService;
import com.project.ecommerce.service.MailService;
import com.project.ecommerce.service.PasswordResetTokenService;
import com.project.ecommerce.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/auth")
public class AuthViewController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @Autowired
    private MailService mailService;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterDTO());
        return "register"; // register.html
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerRequest") RegisterDTO request,
                                  Model model) {
        try {
            authService.register(request);
            model.addAttribute("success", "Đăng ký thành công!");
            return "register";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, HttpServletRequest request, Model model) {

        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "Email không tồn tại");
            return "forgot-password";
        }
        String token =passwordResetTokenService.createResetToken(user);

        String link = request.getScheme() + "://" +
                request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath() +
                "/auth/reset-password?token=" + token;

        MailDTO mailDTO = new MailDTO();
        mailDTO.setTo(user.getEmail());
        mailDTO.setSubject("Reset Password");
        mailDTO.setContent("Bạn đã yêu cầu đặt lại mật khẩu.\n\n" +
                "Vui lòng truy cập link bên dưới để tiếp tục:\n" +
                link + "\n\n" +
                "Link có hiệu lực trong 1 phút.");

        mailService.sendMail(mailDTO);

        model.addAttribute("message", "Link reset đã được gửi qua email");
        return "forgot-password";
    }

    @GetMapping("/reset-password")
    public String resetPasswordForm(
            @RequestParam String token,
            Model model) {

        PasswordResetToken resetToken = passwordResetTokenService.findByToken(token);
        if (resetToken == null ||
                resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            model.addAttribute("error", "Token không hợp lệ hoặc đã hết hạn");
            return "error";
        }

        model.addAttribute("token", token);
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String handleResetPassword(
            @RequestParam String token,
            @RequestParam String password) {

        authService.resetPassword(token, password);

        return "redirect:/auth/login?resetSuccess";
    }
}
