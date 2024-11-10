package com.ms.notificaciones.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Value("${mail.username}")
    private String mailUsername;

    @Value("${mail.password}")
    private String mailPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // Indicamos cuál será el host del proveedor
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(mailUsername);
        mailSender.setPassword(mailPassword);

        Properties props = mailSender.getJavaMailProperties();

        // Indicamos que se utilizará este protocolo para el envío de correo
        props.put("mail.transport.protocol", "smtp");
        // Habilitando la autenticación
        // cuando se inicie la aplicación se autenticará con nuestro user y pass
        // Si no se ha autenticado, no puede enviar el correo electrónico.
        props.put("mail.smtp.auth", "true");
        // Habilitando el cifrado entre la comunicación de nuestra aplicación y nuestro correo
        // mediante el smtp
        props.put("mail.smtp.starttls.enable", "true");
        // Para que en la consola nos imprima info acerca de la comunicación entre nuestra app y el correo
        props.put("mail.debug", "true");
        return mailSender;
    }
}
