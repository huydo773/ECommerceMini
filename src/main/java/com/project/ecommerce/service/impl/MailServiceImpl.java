package com.project.ecommerce.service.impl;

import com.project.ecommerce.dto.MailDTO;
import com.project.ecommerce.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(MailDTO mailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDTO.getTo());
        message.setSubject(mailDTO.getSubject());
        message.setText(mailDTO.getContent());
        mailSender.send(message);
    }
}
