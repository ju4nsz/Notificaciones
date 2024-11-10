package com.ms.notificaciones.domain.service.impl;

import com.ms.notificaciones.domain.service.in.IMailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class MailSenderServiceImpl implements IMailSenderService {

    private final JavaMailSender mailSender;

    @Value("${mail.username}")
    private String mailUsername;

    @Override
    public void enviarEmail(String[] to, String subject, String body) throws MailException, MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

        messageHelper.setFrom(mailUsername);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(body, true);

        mailSender.send(mimeMessage);

    }

}
