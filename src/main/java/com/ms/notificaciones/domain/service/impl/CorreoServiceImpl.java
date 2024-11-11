package com.ms.notificaciones.domain.service.impl;

import com.ms.notificaciones.domain.models.consts.EstadoCorreoEnum;
import com.ms.notificaciones.domain.models.dto.CorreoEnviadoDto;
import com.ms.notificaciones.domain.models.dto.CorreoPlantillaDto;
import com.ms.notificaciones.domain.models.dto.CorreoRegistroDto;
import com.ms.notificaciones.domain.models.request.EnviarCorreoRequest;
import com.ms.notificaciones.domain.models.response.RespuestaGenerica;
import com.ms.notificaciones.domain.service.in.ICorreoService;
import com.ms.notificaciones.domain.service.in.IMailSenderService;
import com.ms.notificaciones.domain.service.out.ICorreoEnviadoOutService;
import com.ms.notificaciones.domain.service.out.ICorreoEstadoOutService;
import com.ms.notificaciones.domain.service.out.ICorreoPlantillaOutService;
import com.ms.notificaciones.domain.util.CorreoUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CorreoServiceImpl implements ICorreoService {

    private final ICorreoPlantillaOutService correoPlantillaOutService;
    private final ICorreoEnviadoOutService correoEnviadoOutService;
    private final ICorreoEstadoOutService correoEstadoOutService;
    private final IMailSenderService mailSenderService;
    private final CorreoUtil correoUtil;

    @Override
    public Map<String, Object> enviarCorreo(EnviarCorreoRequest request) throws MessagingException {

        CorreoPlantillaDto correoPlantillaDto = correoPlantillaOutService.buscarPlantilla(request.getNombrePlantilla());
        String cuerpo = correoUtil.reemplazarTexto(correoPlantillaDto.getCuerpo(), request.getParametros());

        mailSenderService.enviarEmail(new String[]{request.getCorreo()}, correoPlantillaDto.getAsunto(), cuerpo);

        correoEnviadoOutService.guardar(CorreoEnviadoDto.builder()
                        .correoDestino(request.getCorreo())
                        .correoPlantilla(correoPlantillaDto)
                        .idUsuario(request.getIdUsuario())
                        .correoEstado(correoEstadoOutService.buscarPorId(EstadoCorreoEnum.INFORMATIVO.toValue()))
                .build());

        Map<String, Object> response = new HashMap<>();
        response.put("Correo enviado exitosamente.", request.getCorreo());
        return response;
    }

}
