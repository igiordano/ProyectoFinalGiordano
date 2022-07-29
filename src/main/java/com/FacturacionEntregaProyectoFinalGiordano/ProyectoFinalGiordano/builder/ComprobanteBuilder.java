package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ClienteEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ComprobanteEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ComprobanteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ClienteResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ComprobanteResponse;

import java.util.List;
import java.util.stream.Collectors;

// CAPA ComprobanteBuilder en esta capa se construye a la entidad comprobante con sus datos
public class ComprobanteBuilder {
    public static ComprobanteResponse entityToResponse(ComprobanteEntity comprobante) {
        return ComprobanteResponse.builder()
                .comprobanteId(comprobante.getComprobanteId())
                .cantidad(comprobante.getCantidad())
                .fecha(comprobante.getFecha())
                .total(comprobante.getTotal())
                .estado(comprobante.getEstado())
                .cliente(ClienteResponse.builder().build())
                .build();
    }

    public static ComprobanteEntity requestToEntity(ComprobanteRequest comprobante) {
        return ComprobanteEntity.builder()
                .comprobanteId(comprobante.getComprobanteId())
                .cantidad(comprobante.getCantidad())
                .fecha(comprobante.getFecha())
                .total(comprobante.getTotal())
                .estado(comprobante.getEstado())
                .cliente(ClienteEntity.builder().build())
                .build();
    }

    public static List<ComprobanteResponse> entityToResponseList(List<ComprobanteEntity> entities) {
        return entities.stream().map(ComprobanteBuilder::entityToResponse).collect(Collectors.toList());
    }
}
