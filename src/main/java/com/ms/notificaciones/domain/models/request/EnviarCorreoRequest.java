package com.ms.notificaciones.domain.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnviarCorreoRequest {

    @NotNull(message = "La id del usuario no puede ser nula.")
    private Integer idUsuario;

    @NotBlank(message = "El nombre de usuario no puede ser nulo.")
    private String username;

    @Email(message = "Debe ser un email válido")
    @NotBlank(message = "El correo no puede ser nulo.")
    private String correo;

    @NotBlank(message = "El nombre de la plantilla no puede ser nulo.")
    private String nombrePlantilla;

}
