package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ProductoEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ProductoRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ProductoResponse;

import java.util.List;
import java.util.stream.Collectors;

// CAPA ProductoBuilder en esta capa se construye a la entidad producto con sus datos
public class ProductoBuilder {
    public static ProductoResponse entityToResponse(ProductoEntity producto) {
        return ProductoResponse.builder()
                .productoId(producto.getProductoId().intValue())
                .codigo(producto.getCodigo())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .descripcion(producto.getDescripcion())
                .build();
    }

    public static List<ProductoResponse> entityToResponseList(List<ProductoEntity> entityList) {
        return entityList.stream().map(ProductoBuilder::entityToResponse).collect(Collectors.toList());
    }

    public static ProductoEntity requestToEntity(ProductoRequest producto) {
        return ProductoEntity.builder()
                .codigo(producto.getCodigo())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .descripcion(producto.getDescripcion())
                .build();
    }
}
