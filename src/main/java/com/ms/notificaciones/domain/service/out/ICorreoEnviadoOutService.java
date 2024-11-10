package com.ms.notificaciones.domain.service.out;

import com.ms.notificaciones.domain.models.dto.CorreoEnviadoDto;

public interface ICorreoEnviadoOutService {

    CorreoEnviadoDto guardar(CorreoEnviadoDto correoEnviado);

}
