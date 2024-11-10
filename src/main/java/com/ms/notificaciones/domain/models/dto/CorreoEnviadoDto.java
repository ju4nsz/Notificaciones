package com.ms.notificaciones.domain.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CorreoEnviadoDto {

    private Integer id;
    private String correoDestino;
    private Integer idUsuario;
    private CorreoPlantillaDto correoPlantilla;
    private CorreoEstadoDto correoEstado;

}
