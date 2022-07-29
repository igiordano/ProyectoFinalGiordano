package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemResponse {

    private Long itemId;
    private Integer cantidad;
    private String descripcion;
    private BigDecimal precio;
    private ComprobanteResponse comprobante;
    private ProductoResponse producto;
}
