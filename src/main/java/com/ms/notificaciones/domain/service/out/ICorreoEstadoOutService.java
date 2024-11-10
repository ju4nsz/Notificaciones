package com.ms.notificaciones.domain.service.out;

import com.ms.notificaciones.domain.models.dto.CorreoEstadoDto;

public interface ICorreoEstadoOutService {

    CorreoEstadoDto buscarPorId(Integer id);

}
