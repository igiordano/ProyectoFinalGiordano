package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//EN ESTA CAPA CLASE SE CREA EL ComprobanteEntity LA CUAL PRESENTA LOS DATOS DE LA TABLA COMPROBANTE DE LA BBDD VENTAS//
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "COMPROBANTE")
public class ComprobanteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "COMPROBANTEID")
    private Long comprobanteId;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @Column(name = "ESTADO")
    private Integer estado;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="DNI")
    private ClienteEntity cliente;

}
