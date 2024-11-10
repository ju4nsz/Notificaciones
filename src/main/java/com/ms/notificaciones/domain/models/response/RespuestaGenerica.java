package com.ms.notificaciones.domain.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RespuestaGenerica {

    private boolean status;
    private String message;

    public static RespuestaGenerica ok(boolean status, String message) {
        return new RespuestaGenerica(status, message);
    }

}

