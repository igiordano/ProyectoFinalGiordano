package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Validated
public class ProductoRequest {

    private Integer codigo;
    private String descripcion;
    private Integer stock;
    private BigDecimal precio;
}
