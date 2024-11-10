package com.ms.notificaciones.domain.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorreoPlantillaDto {

    private Integer id;
    private String nombre;
    private String asunto;
    private String cuerpo;
    private TipoNotificacionDto tipoNotificacion;

}
