package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Validated
public class ItemRequest {

    private Long itemId;
    private Integer cantidad;
    private String descripcion;
    private BigDecimal precio;
    private ComprobanteRequest comprobante;
    private ProductoRequest producto;
}
