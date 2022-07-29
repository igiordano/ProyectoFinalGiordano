package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {

    private String nombre;
    private String apellido;
    private long dni;
}
