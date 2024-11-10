package com.ms.notificaciones.domain.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CorreoEstadoDto {

    private Integer id;
    private String nombre;
    private String descripcion;

}
