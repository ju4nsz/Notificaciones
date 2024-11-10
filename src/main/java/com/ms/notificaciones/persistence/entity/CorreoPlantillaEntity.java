package com.ms.notificaciones.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "correo_plantillas")
@Getter
@Setter
public class CorreoPlantillaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String asunto;
    private String cuerpo;

    @ManyToOne
    private TipoNotificacionEntity tipoNotificacion;

    @OneToMany(mappedBy = "correoPlantilla")
    private List<CorreoEnviadoEntity> enviados;

}
