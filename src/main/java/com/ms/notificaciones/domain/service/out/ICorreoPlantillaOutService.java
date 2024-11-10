package com.ms.notificaciones.domain.service.out;

import com.ms.notificaciones.domain.models.dto.CorreoPlantillaDto;

public interface ICorreoPlantillaOutService {

    CorreoPlantillaDto buscarPlantilla(String nombre);

}
