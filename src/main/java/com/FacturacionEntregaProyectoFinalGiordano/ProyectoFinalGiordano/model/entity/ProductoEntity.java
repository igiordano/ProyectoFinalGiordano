package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//EN ESTA CAPA CLASE SE CREA EL ProductoEntity LA CUAL PRESENTA LOS DATOS DE LA TABLA PRODUCTO DE LA BBDD VENTAS//
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "PRODUCTO")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PRODUCTOID")
    private Long productoId;

    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "PRECIO")
    private BigDecimal precio;

}
