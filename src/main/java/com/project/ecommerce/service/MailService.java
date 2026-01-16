package com.project.ecommerce.service;

import com.project.ecommerce.dto.MailDTO;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendMail(MailDTO mailDTO);
}
