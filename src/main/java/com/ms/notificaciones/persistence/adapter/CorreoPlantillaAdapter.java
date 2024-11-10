package com.ms.notificaciones.persistence.adapter;

import com.ms.notificaciones.domain.models.dto.CorreoPlantillaDto;
import com.ms.notificaciones.domain.service.out.ICorreoPlantillaOutService;
import com.ms.notificaciones.persistence.mapper.CorreoMapper;
import com.ms.notificaciones.persistence.repository.CorreoPlantillaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CorreoPlantillaAdapter implements ICorreoPlantillaOutService {

    private final CorreoPlantillaRepository correoPlantillaRepository;
    private final CorreoMapper correoMapper;

    @Override
    public CorreoPlantillaDto buscarPlantilla(String nombre) {
        return correoPlantillaRepository.findByNombre(nombre)
                .map(correoMapper::toCorreoPlantillaDto)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la plantilla del correo con nombre ".concat(nombre)));
    }
}
