package com.ms.notificaciones.persistence.adapter;

import com.ms.notificaciones.domain.models.dto.CorreoEstadoDto;
import com.ms.notificaciones.domain.service.out.ICorreoEstadoOutService;
import com.ms.notificaciones.persistence.mapper.CorreoMapper;
import com.ms.notificaciones.persistence.repository.CorreoEstadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CorreoEstadoAdapter implements ICorreoEstadoOutService {

    private final CorreoEstadoRepository correoEstadoRepository;
    private final CorreoMapper correoMapper;

    @Override
    public CorreoEstadoDto buscarPorId(Integer id) {
        return correoEstadoRepository.findById(id)
                .map(correoMapper::toCorreoEstadoDto)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el estado de correo con id: ".concat(id.toString())));
    }
}
