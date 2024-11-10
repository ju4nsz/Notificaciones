package com.ms.notificaciones.persistence.repository;

import com.ms.notificaciones.persistence.entity.CorreoPlantillaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CorreoPlantillaRepository extends CrudRepository<CorreoPlantillaEntity, Integer> {

    Optional<CorreoPlantillaEntity> findByNombre(String nombre);

}
