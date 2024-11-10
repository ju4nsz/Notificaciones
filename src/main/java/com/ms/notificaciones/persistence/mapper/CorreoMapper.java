package com.ms.notificaciones.persistence.mapper;

import com.ms.notificaciones.domain.models.dto.CorreoEnviadoDto;
import com.ms.notificaciones.domain.models.dto.CorreoEstadoDto;
import com.ms.notificaciones.domain.models.dto.CorreoPlantillaDto;
import com.ms.notificaciones.persistence.entity.CorreoEnviadoEntity;
import com.ms.notificaciones.persistence.entity.CorreoEstadoEntity;
import com.ms.notificaciones.persistence.entity.CorreoPlantillaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorreoMapper {

    CorreoPlantillaDto toCorreoPlantillaDto(CorreoPlantillaEntity entity);

    CorreoEnviadoEntity toCorreoEnviadoEntity(CorreoEnviadoDto dto);

    CorreoEnviadoDto toCorreoEnviadoDto(CorreoEnviadoEntity entity);

    CorreoEstadoEntity toCorreoEstadoEntity(CorreoEstadoDto dto);

    CorreoEstadoDto toCorreoEstadoDto(CorreoEstadoEntity entity);

}
