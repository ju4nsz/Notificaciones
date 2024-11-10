package com.ms.notificaciones.persistence.adapter;

import com.ms.notificaciones.domain.models.dto.CorreoEnviadoDto;
import com.ms.notificaciones.domain.service.out.ICorreoEnviadoOutService;
import com.ms.notificaciones.persistence.mapper.CorreoMapper;
import com.ms.notificaciones.persistence.repository.CorreoEnviadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CorreoEnviadoAdapter implements ICorreoEnviadoOutService {

    private final CorreoEnviadoRepository correoEnviadoRepository;
    private final CorreoMapper correoMapper;

    @Override
    public CorreoEnviadoDto guardar(CorreoEnviadoDto correoEnviado) {
        return correoMapper.toCorreoEnviadoDto(correoEnviadoRepository.save(correoMapper.toCorreoEnviadoEntity(correoEnviado)));
    }
}
