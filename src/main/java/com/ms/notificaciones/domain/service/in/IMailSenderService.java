package com.ms.notificaciones.domain.service.in;

import jakarta.mail.MessagingException;
import org.springframework.mail.MailException;

public interface IMailSenderService {

    void enviarEmail(String [] to, String subject, String body) throws MailException, MessagingException;

}
