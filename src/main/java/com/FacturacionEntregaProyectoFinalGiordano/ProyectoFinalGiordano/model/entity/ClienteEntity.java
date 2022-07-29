package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//EN ESTA CAPA CLASE SE CREA EL ClienteEntity LA CUAL PRESENTA LOS DATOS DE LA TABLA CLIENTE DE LA BBDD VENTAS//

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

    @Column(name = "DNI")
    @Id
    private long dni;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

}
