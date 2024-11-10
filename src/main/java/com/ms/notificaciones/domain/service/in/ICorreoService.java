package com.ms.notificaciones.domain.service.in;

import com.ms.notificaciones.domain.models.request.EnviarCorreoRequest;
import com.ms.notificaciones.domain.models.response.RespuestaGenerica;
import jakarta.mail.MessagingException;

public interface ICorreoService {

    RespuestaGenerica enviarCorreo(EnviarCorreoRequest request) throws MessagingException;

}
