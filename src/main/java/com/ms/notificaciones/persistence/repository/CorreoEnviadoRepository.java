package com.ms.notificaciones.persistence.repository;

import com.ms.notificaciones.persistence.entity.CorreoEnviadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CorreoEnviadoRepository extends CrudRepository<CorreoEnviadoEntity, Integer> {
}
