package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ClienteRequest {


    private String nombre;
    private String apellido;
    private Long dni;

}
