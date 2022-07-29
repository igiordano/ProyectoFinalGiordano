package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ClienteEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ClienteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ClienteResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// CAPA ClienteBuilder en esta capa se construye a la entidad cliente con sus datos
public class ClienteBuilder {
    public static ClienteResponse entityToResponse(ClienteEntity cliente) {
        if (Objects.nonNull(cliente)) {
            return ClienteResponse.builder()
                    .dni(cliente.getDni())
                    .apellido(cliente.getApellido())
                    .nombre(cliente.getNombre())
                    .build();
        }
        return null;
    }

    public static List<ClienteResponse> entityToResponseList(List<ClienteEntity> entityList) {
        return entityList.stream().map(ClienteBuilder::entityToResponse).collect(Collectors.toList());
    }

    public static ClienteEntity requestToEntity(ClienteRequest cliente) {
        return ClienteEntity.builder()
                .dni(cliente.getDni())
                .apellido(cliente.getApellido())
                .nombre(cliente.getNombre())
                .build();
    }
}
