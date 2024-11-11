package com.ms.notificaciones.web.controller;

import com.ms.notificaciones.domain.models.request.EnviarCorreoRequest;
import com.ms.notificaciones.domain.models.response.RespuestaGenerica;
import com.ms.notificaciones.domain.service.in.ICorreoService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notificaciones")
public class CorreoController {

    private final ICorreoService correoService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> enviarCorreoElectronico(@RequestBody @Valid EnviarCorreoRequest request) throws MessagingException {
        return ResponseEntity.ok(correoService.enviarCorreo(request));
    }

}
