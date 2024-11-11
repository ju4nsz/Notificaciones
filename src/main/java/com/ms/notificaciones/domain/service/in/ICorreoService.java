package com.ms.notificaciones.domain.service.in;

import com.ms.notificaciones.domain.models.request.EnviarCorreoRequest;
import jakarta.mail.MessagingException;

import java.util.Map;

public interface ICorreoService {

    Map<String, Object> enviarCorreo(EnviarCorreoRequest request) throws MessagingException;

}
