package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ComprobanteResponse {

    private Long comprobanteId;
    private Integer cantidad;
    private Date fecha;
    private BigDecimal total;
    private Integer estado;
    private ClienteResponse cliente;

}
