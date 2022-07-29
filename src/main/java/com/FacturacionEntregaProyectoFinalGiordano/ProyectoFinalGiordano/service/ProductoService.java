package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ProductoRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ProductoResponse;

import java.util.List;

// INTERFACE ProductoService con los metodos, se usan en la clases ProductoServiceImpl y  ProductoController//
public interface ProductoService {
    ProductoResponse buscarPorId(Long ProductoId);
    ProductoResponse buscarPorCodigo(Integer codigo);
    List<ProductoResponse> buscarTodos();
    ProductoResponse crear(ProductoRequest producto) throws ApiException;
    ProductoResponse actualizar(ProductoRequest producto) throws ApiException;
    void eliminar(ProductoRequest producto) throws ApiException;
    void eliminarPorId(Long ProductoId);
}
