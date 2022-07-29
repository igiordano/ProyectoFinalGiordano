package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ComprobanteEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ItemEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ProductoEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ItemRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ComprobanteResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ItemResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ProductoResponse;

import java.util.List;
import java.util.stream.Collectors;

// CAPA ItemBuilder en esta capa se construye a la entidad item con sus datos
public class ItemBuilder {

    public static ItemResponse entityToResponse(ItemEntity item) {
        return ItemResponse.builder()
                .itemId(item.getItemId())
                .cantidad(item.getCantidad())
                .descripcion(item.getDescripcion())
                .precio(item.getPrecio())
                .comprobante(ComprobanteResponse.builder().build())
                .producto(ProductoResponse.builder().build())
                .build();
    }

    public static ItemEntity requestToEntity(ItemRequest item) {
        return ItemEntity.builder()
                .itemId(item.getItemId())
                .cantidad(item.getCantidad())
                .descripcion(item.getDescripcion())
                .precio(item.getPrecio())
                .comprobante(ComprobanteEntity.builder().build())
                .producto(ProductoEntity.builder().build())
                .build();
    }

    public static List<ItemResponse> entityToResponseList(List<ItemEntity> entities) {
        return entities.stream().map(ItemBuilder::entityToResponse).collect(Collectors.toList());
    }



}
