package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Validated
public class ComprobanteRequest {
    private Long comprobanteId;
    private Integer cantidad;
    private Date fecha;
    private BigDecimal total;
    private Integer estado;
    private ClienteRequest cliente;



}
