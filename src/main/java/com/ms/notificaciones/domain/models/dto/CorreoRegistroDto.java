package com.ms.notificaciones.domain.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CorreoRegistroDto {

    private Object parametros;
    private String enlace;
    private String enlaceAyuda;
    private String tipoNotificacion;

}
