package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductoResponse {

    private Integer productoId;
    private Integer codigo;
    private String descripcion;
    private Integer stock;
    private BigDecimal precio;
}
