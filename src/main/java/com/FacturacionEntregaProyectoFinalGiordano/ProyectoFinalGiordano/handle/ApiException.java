package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle;

public class ApiException extends Exception{

    private String message;

    public ApiException(String message) {
        super(message);
    }
}
