package com.ms.notificaciones.domain.models.consts;

public enum EstadoCorreoEnum {
    INFORMATIVO(1);

    private final Integer idEstadoCorreo;

    EstadoCorreoEnum(Integer idEstadoCorreo){
        this.idEstadoCorreo = idEstadoCorreo;
    }

    public Integer toValue() {
        return this.idEstadoCorreo;
    }

}
