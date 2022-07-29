package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ItemRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ItemResponse;

import java.util.List;
// INTERFACE ItemService con los metodos, se usan en la clases ItemServiceImpl y ItemController//
public interface ItemService {
    ItemResponse buscarPorIdItem(Long ItemId) throws ApiException;
    List<ItemResponse> buscarTodos();
    ItemResponse crear(ItemRequest item) throws ApiException;
    ItemResponse actualizar(ItemRequest item) throws ApiException;
    void eliminar(ItemRequest item) throws ApiException;
    void eliminarPorIdItem(Long ItemId);
}
