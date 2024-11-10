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

@Service
@RequiredArgsConstructor
public class CorreoServiceImpl implements ICorreoService {

    private final ICorreoPlantillaOutService correoPlantillaOutService;
    private final ICorreoEnviadoOutService correoEnviadoOutService;
    private final ICorreoEstadoOutService correoEstadoOutService;
    private final IMailSenderService mailSenderService;
    private final CorreoUtil correoUtil;

    @Override
    public RespuestaGenerica enviarCorreo(EnviarCorreoRequest request) throws MessagingException {

        CorreoPlantillaDto correoPlantillaDto = correoPlantillaOutService.buscarPlantilla(request.getNombrePlantilla());
        String cuerpo = correoUtil.reemplazarTexto(correoPlantillaDto.getCuerpo(), CorreoRegistroDto.builder()
                .username(request.getUsername())
                .enlace("www.google.com")
                .enlaceAyuda("www.google.com")
                .tipoNotificacion(correoPlantillaDto.getTipoNotificacion().getNombre())
                .build());

        mailSenderService.enviarEmail(new String[]{request.getCorreo()}, correoPlantillaDto.getAsunto(), cuerpo);

        correoEnviadoOutService.guardar(CorreoEnviadoDto.builder()
                        .correoDestino(request.getCorreo())
                        .correoPlantilla(correoPlantillaDto)
                        .idUsuario(request.getIdUsuario())
                        .correoEstado(correoEstadoOutService.buscarPorId(EstadoCorreoEnum.INFORMATIVO.toValue()))
                .build());

        return RespuestaGenerica.ok(true, "¡Se ha enviado el correo electrónico exitosamente!");
    }

}
