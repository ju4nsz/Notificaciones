package com.ms.notificaciones.domain.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class EnviarCorreoRequest {

    @NotNull(message = "La id del usuario no puede ser nula.")
    private Integer idUsuario;

    @NotNull(message = "Los parámetros no pueden ser nulos.")
    private LinkedHashMap<String, Object> parametros;

    @Email(message = "Debe ser un email válido")
    @NotBlank(message = "El correo no puede ser nulo.")
    private String correo;

    @NotBlank(message = "El nombre de la plantilla no puede ser nulo.")
    private String nombrePlantilla;

}
