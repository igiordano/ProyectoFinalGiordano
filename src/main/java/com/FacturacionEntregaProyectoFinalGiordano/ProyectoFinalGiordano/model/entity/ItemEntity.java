package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//EN ESTA CAPA CLASE SE CREA EL ItemEntity LA CUAL PRESENTA LOS DATOS DE LA TABLA ITEM DE LA BBDD VENTAS//
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ITEMID")
    private Long itemId;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private BigDecimal precio;

    //bi-directional many-to-one association to Comprobante
    @ManyToOne
    @JoinColumn(name="comprobanteid")
    private ComprobanteEntity comprobante;

    //bi-directional many-to-one association to Producto
    @ManyToOne
    @JoinColumn(name="productoid")
    private ProductoEntity producto;

}
