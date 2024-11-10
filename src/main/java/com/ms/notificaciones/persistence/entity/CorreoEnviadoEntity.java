package com.ms.notificaciones.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "correo_enviados")
@Getter
@Setter
public class CorreoEnviadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "correo_destino")
    private String correoDestino;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @ManyToOne
    private CorreoPlantillaEntity correoPlantilla;

}
