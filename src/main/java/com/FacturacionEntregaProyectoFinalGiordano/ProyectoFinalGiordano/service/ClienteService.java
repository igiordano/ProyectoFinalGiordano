package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ClienteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ClienteResponse;

import java.util.List;
// INTERFACE ClienteService con los metodos, se usan en la clases ClienteServiceImpl y ClienteController //
public interface ClienteService {
    ClienteResponse buscarPorDni(Long dni) throws ApiException;
    List<ClienteResponse> buscarTodos();
    ClienteResponse crear(ClienteRequest cliente) throws ApiException;
    ClienteResponse actualizar(ClienteRequest cliente) throws ApiException;
    void eliminar(ClienteRequest cliente) throws ApiException;
    void eliminarPorDni(Long dni);
}
